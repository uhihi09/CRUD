package com.example.demo.controller;

import com.example.demo.dto.PostRequestDto;
import com.example.demo.entity.Post;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService service;

    @GetMapping
    public List<Post> getAll() {
        return service.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getOne(@PathVariable("id") Long id) {
        return service.getPost(id);
    }

    @PostMapping
    public Post create(@RequestBody PostRequestDto dto) {
        return service.createPost(dto);
    }

    @PatchMapping("/{id}")
    public Post update(@PathVariable("id") Long id, @RequestBody PostRequestDto dto) {
        return service.updatePost(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id, @RequestBody Map<String, String> req) {
        service.deletePost(id, req.get("password"));
        return ResponseEntity.ok().build();
    }
}