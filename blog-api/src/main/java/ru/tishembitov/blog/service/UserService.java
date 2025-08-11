package ru.tishembitov.blog.service;

import ru.tishembitov.blog.model.entity.User;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);
}
