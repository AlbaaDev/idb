package com.faz.idb.service;

import java.util.List;

import com.faz.idb.models.User;

public interface IUserService {
    List<User> getAll();
    void save(User user);
}
