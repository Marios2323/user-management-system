package tests;

import model.Role;
import model.User;
import repository.InMemoryUserRepository;
import service.UserService;
import utils.TestAssertions;

public class UserTests {

    public static void main(String[] args) {
        UserService service = new UserService(new InMemoryUserRepository());

        User user = new User("michael", "1234", Role.USER);
        service.save(user);

        TestAssertions.assertTrue(
                service.exists("michael"),
                "User should exist after save"
        );

        TestAssertions.assertEquals(
                Role.USER,
                service.findByUsername("michael").getRole(),
                "Role should be USER"
        );

        service.delete("michael");

        TestAssertions.assertTrue(
                !service.exists("michael"),
                "User should not exist after delete"
        );

        System.out.println("UserTests PASSED");
    }
}