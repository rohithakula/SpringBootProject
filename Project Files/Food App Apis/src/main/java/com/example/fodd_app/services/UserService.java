package com.example.fodd_app.services;

import java.util.List;

import com.example.fodd_app.payloads.ApiResponses;
import com.example.fodd_app.payloads.LoginDto;
import com.example.fodd_app.payloads.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user, Integer userId);
	UserDto getUser(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);


	ApiResponses LoginUser(LoginDto loginDto);
}
