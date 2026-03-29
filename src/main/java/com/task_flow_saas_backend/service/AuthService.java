package com.task_flow_saas_backend.service;

import org.springframework.stereotype.Service;

import com.task_flow_saas_backend.entity.User;
import com.task_flow_saas_backend.repository.UserRepository;
import com.task_flow_saas_backend.security.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final UserRepository userRepository;

    private final JwtUtil jwtUtil;

    public String login(String email,String password){
        User user=userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("User not found"));
        if(!user.getPassword().equals(password)){
            throw new RuntimeException("Invalid password");
        }
        return jwtUtil.generateToken(email);
    }
     public User signup(User user) {
        return userRepository.save(user);
    }

}
