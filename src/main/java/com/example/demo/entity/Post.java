package com.example.demo.entity;

import jakarta.persistence.*; // @Entity, @Id, @GeneratedValue, @GenerationType 어노테이션을 위한 import (Spring Boot 3.x 이상)
// import javax.persistence.*; // Spring Boot 2.x 이하를 사용하는 경우 이 라인을 사용하세요.
import lombok.AllArgsConstructor; // Lombok의 @AllArgsConstructor 어노테이션을 위한 import
import lombok.Data; // Lombok의 @Data 어노테이션을 위한 import
import lombok.NoArgsConstructor; // Lombok의 @NoArgsConstructor 어노테이션을 위한 import

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String title;
    private String content;
    private String id;       // 작성자 ID
    private String password; // 비밀번호
}