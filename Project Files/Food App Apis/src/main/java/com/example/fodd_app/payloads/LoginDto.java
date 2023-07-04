package com.example.fodd_app.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor

@Setter
@Getter
public class LoginDto {

    private String mail;
    private String password;
}
