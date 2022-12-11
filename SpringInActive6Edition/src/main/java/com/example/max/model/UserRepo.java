package com.example.max.model;

import lombok.Data;

@Data
public class UserRepo {

	private Long id;
	private String username;
	private String password;
	private String repeatPassword;
}
