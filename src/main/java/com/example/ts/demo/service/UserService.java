package com.example.ts.demo.service;

import com.example.ts.demo.entity.User;
import com.example.ts.demo.jwt.JwtUtil;
import com.example.ts.demo.repository.UserRepository;
import com.example.ts.demo.utils.Util;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public UserService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    //в миграции создать по умолчанию роль USER
    @SneakyThrows
    public User createUser(User user){
        if(isLoginExists(user.getLogin())){
            System.out.println("User with this login already exists");
        }
        user.setPassword(Util.encodePass(user.getPassword()));
//        user.setRole("user");
        return this.userRepository.save(user);
    }

    private boolean isLoginExists(String login) {
        return this.userRepository.existsByLogin(login);
    }
}
