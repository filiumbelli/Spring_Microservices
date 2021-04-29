package com.sofisticat.rest.webservices.service;

import com.sofisticat.rest.webservices.dao.PostRepository;
import com.sofisticat.rest.webservices.dao.UserRepository;
import com.sofisticat.rest.webservices.entity.Post;
import com.sofisticat.rest.webservices.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;


    // Get user
    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }

    // Get user posts
    public List<Post> getUserPosts(long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get().getPosts();
    }

    // Create a post
    public void createPost(Post post, long id) {

        User user = userRepository.findById(id).get();
        post.setUser(user);
        user.addPost(post);
        postRepository.save(post);
    }

    // Get the post
    public Post getPost(long id, long postId) {
        User user = getUserById(id);
        if (user.getId() == postRepository.findById(id).get().getUser().getId()) {
            return postRepository.findById(postId).get();
        }
        return null;
    }

    // Get all users
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // Create a user
    public void createUser(User user) {
        userRepository.save(user);
    }


    // Delete user
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
