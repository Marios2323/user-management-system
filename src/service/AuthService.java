package service;

import exceptions.InvalidCredentialsException;
import model.Role;
import model.User;

public class AuthService {

    private final UserService userService;

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    public boolean login(String username, String password) {
        User user = userService.findByUsername(username);

        if (!user.getPassword().equals(password)) {
            throw new InvalidCredentialsException("Invalid credentials");
        }

        return true;
    }

    public boolean isAdmin(String username) {
        return userService.findByUsername(username).getRole() == Role.ADMIN;
    }
}