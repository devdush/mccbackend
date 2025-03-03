package com.megacitycabs.bookingsystem.service;

import com.megacitycabs.bookingsystem.model.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    public Users saveUser(Users user);
    List<Users> getAllUsers();
    Optional<Users> getUserById(Long id);
    Users updateUser(Long id, Users updatedUser);
    void deleteUser(Long id);
    Optional<Users> loginUser(String email, String password);
}
