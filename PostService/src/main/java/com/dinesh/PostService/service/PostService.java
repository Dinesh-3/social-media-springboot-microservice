package com.dinesh.PostService.service;

import com.dinesh.PostService.entity.Post;
import com.dinesh.PostService.repository.PostRepository;
import com.dinesh.PostService.util.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public ResponseEntity<ResponseBody> getAll() {
        Iterable<Post> posts = repository.findAll();
        ResponseBody responseBody = new ResponseBody(posts);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    public ResponseEntity<ResponseBody> getById(long id) {
        Optional<Post> post = repository.findById(id);
        ResponseBody responseBody = new ResponseBody(post);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    public ResponseEntity<ResponseBody> create(Post post) {
        Post savedUser = repository.save(post);
        ResponseBody responseBody = new ResponseBody(savedUser);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    public ResponseEntity<ResponseBody> delete(long id) {
        repository.deleteById(id);
        ResponseBody responseBody = new ResponseBody(null);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
