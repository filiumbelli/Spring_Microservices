package com.sofisticat.rest.webservices.service;

import com.sofisticat.rest.webservices.dao.PostRepository;
import com.sofisticat.rest.webservices.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    PostRepository postRepository;

    public Post getPostById(long id) {
        return postRepository.findById(id).get();
    }

    public List<Post> getAllPosts(long id) {
        return postRepository.findAll();
    }
}
