package com.example.fodd_app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fodd_app.payloads.ApiResponses;
import com.example.fodd_app.payloads.UserDto;
import com.example.fodd_app.payloads.LoginDto;
import com.example.fodd_app.services.UserService;

@RestController
@RequestMapping("/api/v1/users/")
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//Post - Create User
	@PostMapping("/save")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}

	// Login
	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody LoginDto loginDto){
		ApiResponses loginResponse = this.userService.LoginUser(loginDto);
		return ResponseEntity.ok(loginResponse);
	}
	
	//Put - Update User
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable("userId") Integer uid){

		UserDto updatedUser = this.userService.updateUser(userDto,uid);
		return ResponseEntity.ok(updatedUser);
	}
	
	//Delete - delete user
	
	@DeleteMapping("/udelete{userId}")
	public ResponseEntity<ApiResponses> deleteUser(@PathVariable("userId") Integer id){

		this.deleteUser(id);
		return new ResponseEntity<ApiResponses>(new ApiResponses("User deleted successfull0y", true,0),HttpStatus.OK);
	}

	//Get - users list

	@GetMapping("/getall")
	public ResponseEntity<List<UserDto>> getAllUSers(){

		return ResponseEntity.ok(this.userService.getAllUsers());
	}

	// Get - user get

	@GetMapping("/get{userId}")
	public ResponseEntity<UserDto> getSinleUser(@PathVariable Integer userId){

		return ResponseEntity.ok(this.userService.getUser(userId));
	}
}
