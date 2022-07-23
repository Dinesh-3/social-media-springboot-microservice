package com.dinesh.PostService.controller;

import com.dinesh.PostService.entity.Post;
import com.dinesh.PostService.service.PostService;
import com.dinesh.PostService.util.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/posts")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping()
    ResponseEntity<ResponseBody> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseBody> get(@PathVariable long id) {
        return service.getById(id);
    }

    @PostMapping()
    ResponseEntity<ResponseBody> create(@RequestBody Post post) {
        return service.create(post);
    }

    @PutMapping()
    ResponseEntity<ResponseBody> update(@RequestBody Post post) {
        return service.create(post);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseBody> delete(@PathVariable long id) {
        return service.delete(id);
    }

}
