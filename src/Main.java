import model.Role;
import model.User;
import repository.InMemoryUserRepository;
import repository.UserRepository;
import service.AuthService;
import service.UserService;

public class Main {

    public static void main(String[] args) {

        // Repository layer
        UserRepository userRepository = new InMemoryUserRepository();

        // Service layer
        UserService userService = new UserService(userRepository);
        AuthService authService = new AuthService(userService);

        // Create users
        User user = new User("michael", "1234", Role.USER);
        User admin = new User("admin", "admin123", Role.ADMIN);

        userService.save(user);
        userService.save(admin);

        // Demo flow
        System.out.println("User exists: " + userService.exists("michael"));

        boolean loginResult = authService.login("michael", "1234");
        System.out.println("Login successful: " + loginResult);

        System.out.println("Is admin: " + authService.isAdmin("admin"));

        userService.delete("michael");
        System.out.println("User exists after delete: " + userService.exists("michael"));
    }
}