package com.example.ts.demo.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Util {

    public static String encodePass(String pass) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(pass);
    }
}
