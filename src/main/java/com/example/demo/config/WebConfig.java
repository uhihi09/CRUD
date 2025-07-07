package com.example.demo.config;

import org.springframework.context.annotation.Bean; // @Bean 어노테이션을 위한 import
import org.springframework.context.annotation.Configuration; // @Configuration 어노테이션을 위한 import
import org.springframework.web.servlet.config.annotation.CorsRegistry; // CorsRegistry 클래스를 위한 import
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer; // WebMvcConfigurer 인터페이스를 위한 import

@Configuration
public class WebConfig {
    // CORS 설정 (프론트에서 접근 가능하게)
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*") // 실제 프론트엔드 주소로 변경하는 것이 좋습니다 (예: "http://localhost:3000")
                        .allowedMethods("*"); // 허용할 HTTP 메서드 (GET, POST, PUT, DELETE 등)
            }
        };
    }
}