package service;

import model.User;
import repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        if(userRepository.exists(user.getUsername())) {
            throw new RuntimeException("User already exists");
        }
        userRepository.save(user);
    }

    public void delete(String username) {
        if(!userRepository.exists(username)) {
            throw new RuntimeException("User doesn't exist");
        }
        userRepository.delete(username);
    }

    public boolean exists(String username) {
        return userRepository.exists(username);
    }

    public User findByUsername(String username) {
        if(userRepository.exists(username)) {
            return userRepository.findByUsername(username);
        }
        throw new RuntimeException("User not found");
    }
}