package com.expensetracker.User;

public class UserValidator {
    public void validateUserForCreation(UserEntity user) {
        if (user.getName() == null || user.getName().isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }

        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank.");
        }

        if (user.getPassword() == null || user.getPassword().isBlank()) {
            throw new IllegalArgumentException("Password cannot be null or blank.");
        }
    }

    public void validateUserForUpdate(UserEntity user) {
        if (user.getName() != null && user.getName().isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }

        if (user.getEmail() != null && user.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank.");
        }

        if (user.getPassword() != null && user.getPassword().isBlank()) {
            throw new IllegalArgumentException("Password cannot be null or blank.");
        }
    }
}
