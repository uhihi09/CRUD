package com.example.demo.service;

import com.example.demo.dto.PostRequestDto;
import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;
import lombok.RequiredArgsConstructor; // Lombok의 @RequiredArgsConstructor 어노테이션을 위한 import
import org.springframework.stereotype.Service; // @Service 어노테이션을 위한 import

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repository;

    public List<Post> getAllPosts() {
        return repository.findAll();
    }

    public Post createPost(PostRequestDto dto) {
        Post post = new Post(null, dto.getTitle(), dto.getContent(), dto.getId(), dto.getPassword());
        return repository.save(post);
    }

    public Post updatePost(Long id, PostRequestDto dto) {
        Post post = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글 없음"));
        if (!post.getPassword().equals(dto.getPassword())) {
            throw new IllegalArgumentException("비밀번호 불일치");
        }
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        return repository.save(post);
    }

    public void deletePost(Long id, String password) {
        Post post = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글 없음"));
        if (!post.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호 불일치");
        }
        repository.delete(post);
    }

    public Post getPost(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글 없음"));
    }
}