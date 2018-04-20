package com.intech.api;
import lombok.*;

@Data
@AllArgsConstructor
public class AuthRequestDto {
    private String username;
    private String password;
}