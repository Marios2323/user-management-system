package tests;

import exceptions.InvalidCredentialsException;
import model.Role;
import model.User;
import repository.InMemoryUserRepository;
import service.AuthService;
import service.UserService;
import utils.TestAssertions;

public class AuthTests {

    public static void main(String[] args) {

        UserService userService = new UserService(new InMemoryUserRepository());
        AuthService authService = new AuthService(userService);

        userService.save(new User("admin", "admin123", Role.ADMIN));

        TestAssertions.assertTrue(
                authService.login("admin", "admin123"),
                "Login should succeed"
        );

        TestAssertions.assertTrue(
                authService.isAdmin("admin"),
                "User should be admin"
        );

        TestAssertions.assertThrows(
                InvalidCredentialsException.class,
                () -> authService.login("admin", "wrong"),
                "Login should fail with wrong password"
        );

        System.out.println("AuthTests PASSED");
    }
}