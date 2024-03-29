package com.example.demo.config.envBeanConfig.jwt;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(MyJwtProperties.class)
public class MyJwtConfig {

    public final MyJwtProperties properties;

    public MyJwtConfig(MyJwtProperties myJwtProperties) {
        this.properties = myJwtProperties;
    }

    @Bean
    public MyJwtSource myJwtSource() {

        return MyJwtSource.builder()
                .accessKey(properties.getAccessKey())
                .refreshKey(properties.getRefreshKey())
                .build();
    }
}
