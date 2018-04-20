package com.intech.services;


import com.intech.api.AuthRequestDto;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public boolean login(AuthRequestDto authRequestDto) {

        return authRequestDto.getPassword().equals("formation") && authRequestDto.getUsername().equals("formation");


    }
}
