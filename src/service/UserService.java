package service;

import exceptions.UserAlreadyExistsException;
import exceptions.UserNotFoundException;
import model.User;
import repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        if (userRepository.exists(user.getUsername())) {
            throw new UserAlreadyExistsException("User already exists: " + user.getUsername());
        }
        userRepository.save(user);
    }

    public void delete(String username) {
        if (!userRepository.exists(username)) {
            throw new UserNotFoundException("User not found: " + username);
        }
        userRepository.delete(username);
    }

    public User findByUsername(String username) {
        if (!userRepository.exists(username)) {
            throw new UserNotFoundException("User not found: " + username);
        }
        return userRepository.findByUsername(username);
    }

    public boolean exists(String username) {
        return userRepository.exists(username);
    }
}