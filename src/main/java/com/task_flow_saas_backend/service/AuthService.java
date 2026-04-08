package com.task_flow_saas_backend.service;

import org.springframework.stereotype.Service;

import com.task_flow_saas_backend.entity.Organization;
import com.task_flow_saas_backend.entity.User;
import com.task_flow_saas_backend.repository.OrganizationRepository;
import com.task_flow_saas_backend.repository.UserRepository;
import com.task_flow_saas_backend.security.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final UserRepository userRepository;

    private final OrganizationRepository organizationRepository;

    private final JwtUtil jwtUtil;

    public String login(String email,String password){
        User user=userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("User not found"));
        if(!user.getPassword().equals(password)){
            throw new RuntimeException("Invalid password");
        }
        return jwtUtil.generateToken(user.getEmail(), user.getRole().name());
    }
     public User signup(User user) {

    Organization org = new Organization();
    org.setName("Accenture"); 

    org = organizationRepository.save(org);

    user.setOrganization(org);
        return userRepository.save(user);
    }

}
