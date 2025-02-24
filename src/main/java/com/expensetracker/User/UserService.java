package com.expensetracker.user;

import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(UserEntity user) {
        UserValidator userValidator = new UserValidator();
        userValidator.validateUserForCreation(user);
        return userRepository.save(user);
    }

    public UserEntity getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id: " + id + " not found"));
    }

    public UserEntity updateUser(String id, UserEntity userDetails) {
        UserValidator userValidator = new UserValidator();
        userValidator.validateUserForUpdate(userDetails);

        Optional<UserEntity> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            UserEntity existingUser = optionalUser.get();

            if (userDetails.getName() != null) {
                existingUser.setName(userDetails.getName());
            }

            if (userDetails.getEmail() != null) {
                existingUser.setEmail(userDetails.getEmail());
            }

            if (userDetails.getPassword() != null) {
                existingUser.setPassword(userDetails.getPassword());
            }

            return userRepository.save(existingUser);
        } else {
            throw new EntityNotFoundException("User with id: " + id + " not found.");
        }
    }

    public void deleteUser(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("User with id: " + id + " not found.");
        }
    }
}
