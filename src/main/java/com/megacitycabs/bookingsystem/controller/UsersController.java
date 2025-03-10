package com.megacitycabs.bookingsystem.controller;

import com.megacitycabs.bookingsystem.model.Users;
import com.megacitycabs.bookingsystem.service.UsersService;
import com.megacitycabs.bookingsystem.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private JwtUtil jwtUtil; // ✅ Inject JwtUtil
    @PostMapping("/register")
    public ResponseEntity<Users> add(@RequestBody Users user){
       Users newUser = usersService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);

    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Optional<Users> user = usersService.loginUser(request.getEmail(), request.getPassword());

        if (user.isPresent()) {
            String token = jwtUtil.generateToken(user.get().getUsername());
            return ResponseEntity.ok(new AuthResponse(token, user.get())); // Send both token & user
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<Users>> getAllUsers(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        // Check if the Authorization header exists
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            // Extract the token by removing "Bearer " prefix
            String token = authHeader.substring(7);
            System.out.println("Received Token: " + token);
        } else {
            System.out.println("No valid Authorization header found!");
        }

        return ResponseEntity.ok(usersService.getAllUsers());
    }
    // 🔹 Get User By ID
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        return usersService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 Update User
    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users updatedUser) {
        try {
            Users user = usersService.updateUser(id, updatedUser);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 🔹 Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}

// Login Request DTO
class LoginRequest {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

// Auth Response DTO
class AuthResponse {
    private String token;
    private Users user; // Include user details

    public AuthResponse(String token, Users user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public Users getUser() {
        return user;
    }
}
