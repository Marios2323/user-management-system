import model.Role;
import model.User;
import repository.InMemoryUserRepository;
import repository.UserRepository;

public class Main {
    public static void main(String[] args) {

        UserRepository repo = new InMemoryUserRepository();

        User user = new User("michael", "1234", Role.USER);
        repo.save(user);

        System.out.println(repo.exists("michael"));
        System.out.println(repo.findByUsername("michael").getRole());

        repo.delete("michael");
        System.out.println(repo.exists("michael"));
    }
}