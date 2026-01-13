package service;

import model.Role;
import model.User;
import service.UserService;

public class AuthService {

    private final UserService userService;

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    public boolean login(String username, String password) {
        User user = userService.findByUsername(username);

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials");
        }

        return true;
    }

    public void roleCheck(String username) {
        User user = userService.findByUsername(username);

        if (user.getRole().equals(Role.ADMIN)) {
            System.out.println("Welcome Admin");
        } else {
            System.out.println("Welcome");
        }
    }
}
