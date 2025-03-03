package com.megacitycabs.bookingsystem.service;

import com.megacitycabs.bookingsystem.model.Users;
import com.megacitycabs.bookingsystem.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    private UsersRepository usersRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UsersServiceImpl(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<Users> getUserById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public Users updateUser(Long id, Users updatedUser) {
        return usersRepository.findById(id)
                .map(user -> {
                    user.setUsername(updatedUser.getUsername());
                    user.setEmail(updatedUser.getEmail());
                    user.setPhone(updatedUser.getPhone());
                    user.setPassword(updatedUser.getPassword()); // You should encrypt passwords
                    user.setRole(updatedUser.getRole());
                    return usersRepository.save(user);
                }).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public Optional<Users> loginUser(String email, String rawPassword) {
        Optional<Users> user = usersRepository.findByEmail(email);
        System.out.println(email +" "+rawPassword);
        if (user.isPresent()) {
            // Compare raw password with the hashed password
            if (passwordEncoder.matches(rawPassword, user.get().getPassword())) {
                return user; // Password matched, return user
            }
        }
        return Optional.empty(); // Invalid credentials
    }

    @Override
    public Users saveUser(Users user) {
        // Hash the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersRepository.save(user);
    }
}
