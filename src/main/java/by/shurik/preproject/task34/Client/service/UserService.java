package by.shurik.preproject.task34.Client.service;

import by.shurik.preproject.task34.Client.model.User;

public interface UserService {
    User addUser(User newUser);

    User updateUser(User user);

    String deleteUser(Long id);

    String listUser();
}
