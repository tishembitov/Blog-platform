package ru.tishembitov.blog.service;

import ru.tishembitov.blog.model.CreatePostRequest;
import ru.tishembitov.blog.model.UpdatePostRequest;
import ru.tishembitov.blog.model.entity.Post;
import ru.tishembitov.blog.model.entity.User;

import java.util.List;
import java.util.UUID;

public interface PostService {
    Post getPost(UUID id);
    List<Post> getAllPosts(UUID categoryId, UUID tagId);
    List<Post> getDraftPosts(User user);
    Post createPost(User user, CreatePostRequest createPostRequest);
    Post updatePost(UUID id, UpdatePostRequest updatePostRequest);
    void deletePost(UUID id);
}
