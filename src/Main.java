import model.Role;
import model.User;
import repository.InMemoryUserRepository;
import repository.UserRepository;
import service.AuthService;
import service.UserService;

public class Main {

    public static void main(String[] args) {

        // Repository
        UserRepository userRepository = new InMemoryUserRepository();

        // Services
        UserService userService = new UserService(userRepository);
        AuthService authService = new AuthService(userService);

        // Users
        User user = new User("Michael", "1234", Role.USER);
        User admin = new User("Admin", "admin123", Role.ADMIN);

        userService.save(user);
        userService.save(admin);

        System.out.println("User exists: " + userService.exists("Michael"));

        boolean loginResult = authService.login("Michael", "1234");
        System.out.println("Login successful: " + loginResult
                + " \nUser: " + user.getUsername() + " exists in the database");

        System.out.println("User: " + admin.getUsername() + " is an admin: "
                + authService.isAdmin("Admin"));
        userService.delete("Michael");
        System.out.println("User " + user.getUsername() + " exists in the database after delete: "
                + userService.exists("Michael"));
    }
}