package com.example.demo.web.user;

import com.example.demo.config.security.MyAuthenticationManagerConfig;
import com.example.demo.config.security.MySecurityConfig;
import com.example.demo.config.security.jwt.MyJwtProvider;
import com.example.demo.module.user.UserController;
import com.example.demo.module.user.UserService;
import com.example.demo.util.TestSecurityHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.http.Cookie;

@Import({ MySecurityConfig.class, MyJwtProvider.class, MyAuthenticationManagerConfig.class }) // 추가 하지 않을 경우, 기본
                                                                                              // Security 설정 사용
@WebMvcTest(UserController.class)
public class UserLogoutControllerTest {

        @Autowired
        private MyJwtProvider myJwtProvider;

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private UserService userService;

        @Test
        @DisplayName("로그아웃 성공")
        public void logout_SuccessTest() throws Exception {
                // given
                String accessToken = TestSecurityHelper.createAccessToken(myJwtProvider, 1L, "test@test.com",
                                "testUser");
                String refreshToken = TestSecurityHelper.createRefreshToken(myJwtProvider, 1L, "test@test.com",
                                "testUser");

                Cookie refreshTokenCookie = new Cookie("refreshToken", refreshToken);

                // when
                ResultActions resultActions = mockMvc.perform(delete("/api/auth/logout")
                                .header("Authorization", "Bearer " + accessToken)
                                .cookie(refreshTokenCookie)
                                .accept(MediaType.APPLICATION_JSON));

                // then
                resultActions
                                .andExpect(status().isOk())
                                .andDo(MockMvcResultHandlers.print());

                verify(userService).deleteRefreshToken(refreshToken, 1L);
        }

        @Test
        @DisplayName("로그아웃 실패 - refresh 토큰이 비어있는 경우")
        public void logout_refreshBlank_FailTest() throws Exception {
                // given
                String accessToken = TestSecurityHelper.createAccessToken(myJwtProvider, 1L, "test@test.com",
                                "testUser");

                // when
                ResultActions resultActions = mockMvc.perform(delete("/api/auth/logout")
                                .header("Authorization", "Bearer " + accessToken)
                                .accept(MediaType.APPLICATION_JSON));

                // then
                resultActions
                                .andExpect(status().isBadRequest())
                                .andExpect(jsonPath("$.status").value(400))
                                .andExpect(jsonPath("$.msg").value("badRequest"))
                                .andExpect(jsonPath("$.data").value("RefreshToken이 전송되지 않았습니다. (재로그인 필요)"))
                                .andDo(MockMvcResultHandlers.print());

                verify(userService, never()).deleteRefreshToken("mockRefreshToken", 1L);
        }
}
