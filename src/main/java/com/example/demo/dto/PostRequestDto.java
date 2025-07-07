package com.example.demo.dto;

import lombok.Data; // Lombok의 @Data 어노테이션을 위한 import

@Data
public class PostRequestDto {
    private String title;
    private String content;
    private String id;
    private String password;
}