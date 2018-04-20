package com.intech.services;

<<<<<<< HEAD

import com.intech.api.AuthRequestDto;
=======
import com.intech.api.AuthRequestDto;

>>>>>>> formation-2018-angular
import org.springframework.stereotype.Service;

@Service
public class AuthService {
<<<<<<< HEAD
    public boolean login(AuthRequestDto authRequestDto) {

        return authRequestDto.getPassword().equals("formation") && authRequestDto.getUsername().equals("formation");


    }
=======

    private final String mockUser = "formation";
    private final String mockPassword = "formation";

    public boolean login(AuthRequestDto authRequestDto){
        if(authRequestDto != null && mockUser.equals(authRequestDto.getUsername()) && mockPassword.equals(authRequestDto.getPassword())){
            return true;
        } else {
            return false;
        }
    }

>>>>>>> formation-2018-angular
}
