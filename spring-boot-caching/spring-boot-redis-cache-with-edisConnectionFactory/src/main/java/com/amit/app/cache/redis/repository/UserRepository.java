package com.amit.app.cache.redis.repository;

import java.util.List;
import java.util.Map;

import com.amit.app.models.User;

public interface UserRepository {
    void save(User user);

    Map<String,User> findAll();
    User findById(String id);
    void update(User user);
    void delete(String id);
}
