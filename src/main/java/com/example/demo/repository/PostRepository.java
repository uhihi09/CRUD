package com.example.demo.repository;

import com.example.demo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository; // JpaRepository 인터페이스를 위한 import

public interface PostRepository extends JpaRepository<Post, Long> {
}