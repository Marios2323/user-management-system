package repository;

import model.User;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {

    private final Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getUsername(), user);
    }

    @Override
    public User findByUsername(String username) {
        return users.get(username);
    }

    @Override
    public void delete(String username) {
        users.remove(username);
    }

    @Override
    public boolean exists(String username) {
        return users.containsKey(username);
    }
}