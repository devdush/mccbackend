package com.megacitycabs.bookingsystem.controller;

import com.megacitycabs.bookingsystem.model.Users;
import com.megacitycabs.bookingsystem.service.UsersService;
import com.megacitycabs.bookingsystem.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            return ResponseEntity.ok(new AuthResponse(token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
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

    public AuthResponse(String token) {
        this.token = token;
    }
    public String getToken() {
        return token;
    }

}
