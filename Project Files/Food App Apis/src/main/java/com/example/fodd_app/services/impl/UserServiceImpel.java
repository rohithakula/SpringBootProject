package com.example.fodd_app.services.impl;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import com.example.fodd_app.payloads.ApiResponses;
import com.example.fodd_app.payloads.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fodd_app.entities.user;
import com.example.fodd_app.payloads.UserDto;
import com.example.fodd_app.repositories.UserRepo;
import com.example.fodd_app.services.UserService;
import com.example.fodd_app.exceptions.ResourceNotFoundException;

@Service
public class UserServiceImpel implements UserService {
	
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		
		user user = this.dtoToUser(userDto);
		
		user savedUSer = this.userRepo.save(user);
		return this.userToDto(savedUSer);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		// TODO Auto-generated method stub
		user user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user","id",userId));
		user.setName(userDto.getName());
		user.setAddress(userDto.getAddress());
		user.setMail(userDto.getMail());
		user.setNumber(userDto.getNumber());
		user.setPassword(userDto.getPassword());
		
		user updateUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updateUser);
		
		return userDto1;
	}

	@Override
	public UserDto getUser(Integer userId) {
		// TODO Auto-generated method stub
		user user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user","id",userId));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<user> users = this.userRepo.findAll();
		
		List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		
		user user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user","id",userId));
		
		this.userRepo.delete(user);

	}

	@Override
	public ApiResponses LoginUser(LoginDto loginDto) {
		String msg = "";
		user user1 = userRepo.findByMail(loginDto.getMail());
		if (user1 != null) {
			String password = loginDto.getPassword();
			String user1Password = user1.getPassword();
			Boolean isPwdRight = user1Password.equals(password);
			if (isPwdRight) {
				Optional<user> user = userRepo.findOneByMailAndPassword(loginDto.getMail(), user1Password);
				if (user.isPresent()) {
					return new ApiResponses("Login Success", true,user1.getId());
				} else {
					return new ApiResponses("Login Failed", false,user1.getId());
				}
			} else {
				return new ApiResponses("password Not Match", false,user1.getId());
			}
		}else {
			return new ApiResponses("Email not exits", false,0);
		}
	}


	private user dtoToUser(UserDto userDto) {
		
		user user = new user();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setAddress(userDto.getAddress());
		user.setMail(userDto.getMail());
		user.setNumber(userDto.getNumber());
		user.setPassword(userDto.getPassword());
		
		return user;
		
	}
	
	public UserDto userToDto(user user) {
		
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setAddress(user.getAddress());
		userDto.setMail(user.getMail());
		userDto.setNumber(user.getNumber());
		userDto.setPassword(user.getPassword());
		
		return userDto;
	}

}
