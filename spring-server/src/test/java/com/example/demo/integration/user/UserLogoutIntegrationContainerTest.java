package com.example.demo.integration.user;

import com.example.demo.AbstractIntegrationTest;
import com.example.demo.config.security.jwt.MyJwtProvider;
import com.example.demo.module.refreshtoken.RefreshToken;
import com.example.demo.module.refreshtoken.RefreshTokenRepository;
import com.example.demo.module.user.User;
import com.example.demo.module.user.enums.UserRole;
import com.example.demo.util.DummyEntityHelper;
import com.example.demo.util.TestSecurityHelper;
import com.redis.testcontainers.RedisContainer;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import javax.persistence.EntityManager;
import javax.servlet.http.Cookie;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@Testcontainers
@AutoConfigureRestDocs
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class UserLogoutIntegrationContainerTest extends AbstractIntegrationTest {

        @Autowired
        private MockMvc mockMvc;
        @Autowired
        private EntityManager em;

        @Autowired
        private RefreshTokenRepository refreshTokenRepository;
        @Autowired
        private MyJwtProvider myJwtProvider;

        @Container
        static RedisContainer redisContainer = new RedisContainer(DockerImageName.parse("redis:7.0.8-alpine"))
                        .withExposedPorts(6379);;

        @BeforeEach
        public void init() {
                // rollBack_EmbeddedRedis
                refreshTokenRepository.deleteAll();
        }

        @Test
        @DisplayName("로그아웃 성공")
        public void logout_success() throws Exception {
                // given
                User userEntity = DummyEntityHelper.setUpUser(em, "user1@naver.com", "user1", "abc1", UserRole.COMMON);
                String refreshToken = myJwtProvider.createRefreshToken(userEntity);
                setUp_refreshToken(1L, refreshToken);
                em.flush();
                em.clear();

                Cookie cookie = new Cookie("refreshToken", refreshToken);
                cookie.setPath("/");
                cookie.setHttpOnly(true);
                cookie.setMaxAge(7 * 24 * 60 * 60);

                String accessToken = TestSecurityHelper.createAccessToken(myJwtProvider, 1L, "test@test.com",
                                "testUser");

                // when
                ResultActions resultActions = mockMvc.perform(delete("/api/auth/logout")
                                .header("Authorization", "Bearer " + accessToken)
                                .contentType(MediaType.APPLICATION_JSON)
                                .cookie(cookie)
                                .accept(MediaType.APPLICATION_JSON));

                // then
                resultActions
                                .andExpect(status().isOk())
                                .andDo(MockMvcResultHandlers.print());
                resultActions.andDo(MockMvcResultHandlers.print()).andDo(document);
        }

        @Test
        @DisplayName("로그아웃 실패 - 잘못된 refreshToken 전송")
        public void logout_fail_wrongToken() throws Exception {
                // given
                Cookie cookie = new Cookie("refreshToken", "wrong");
                cookie.setPath("/");
                cookie.setHttpOnly(true);
                cookie.setMaxAge(7 * 24 * 60 * 60);

                String accessToken = TestSecurityHelper.createAccessToken(myJwtProvider, 1L, "test@test.com",
                                "testUser");

                // when
                ResultActions resultActions = mockMvc.perform(delete("/api/auth/logout")
                                .header("Authorization", "Bearer " + accessToken)
                                .contentType(MediaType.APPLICATION_JSON)
                                .cookie(cookie)
                                .accept(MediaType.APPLICATION_JSON));

                // then
                resultActions
                                .andExpect(status().is4xxClientError())
                                .andExpect(jsonPath("$.data").value("RefreshToken 오류 (만료, 잘못된 형식 등, 재로그인 필요)"))
                                .andDo(MockMvcResultHandlers.print());
                resultActions.andDo(MockMvcResultHandlers.print()).andDo(document);
        }

        private void setUp_refreshToken(Long userId, String token) {
                RefreshToken refreshToken = RefreshToken.builder()
                                .userId(userId)
                                .refreshToken(token)
                                .build();

                refreshTokenRepository.save(refreshToken);
        }
}
