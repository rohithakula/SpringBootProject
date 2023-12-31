package com.example.fodd_app.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor

@Setter
@Getter
public class UserDto {
	
	private int id;
	private String name;
	private String mail;
	private String password;
	private String number;
	private String address;
}
