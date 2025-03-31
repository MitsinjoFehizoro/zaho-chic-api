package edu.mitsinjo.zahochic.service.user;

import edu.mitsinjo.zahochic.model.User;

import java.util.Map;

public interface IUserService {
    User currentUser();

    User getUserByUsername(String username);
    User addUser(User user);
    Map<String, Object> authenticateUser(User user);
}
