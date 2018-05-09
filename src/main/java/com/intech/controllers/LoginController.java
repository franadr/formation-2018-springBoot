package com.intech.controllers;

import com.intech.api.AuthRequestDto;
import com.intech.api.AuthResultDto;
import com.intech.services.AuthService;
import com.intech.services.JwtService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log
@RestController
@CrossOrigin
@RequestMapping("/authenticate")
public class LoginController {

    private AuthService authservice;
    private JwtService jwtService;
    public LoginController(AuthService authservice,JwtService jwtService){
        this.jwtService = jwtService;
        this.authservice = authservice;
    }


    @PostMapping(value = "")
    public ResponseEntity<AuthResultDto> doLogin(@RequestBody AuthRequestDto authRequestDto) {
		log.info("POST /authenticate");
        boolean authenticated =  authservice.login(authRequestDto);
        if (authenticated) {
            String jwtToken = jwtService.generateJwt(authRequestDto.getUsername());
            log.info("jwtToken : " + jwtToken);
            return ResponseEntity.accepted().body(new AuthResultDto(jwtToken));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }


}