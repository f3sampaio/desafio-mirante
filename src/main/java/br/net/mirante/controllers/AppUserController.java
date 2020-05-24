package br.net.mirante.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import br.net.mirante.services.UsersService;
import br.net.mirante.viewmodels.response.UserResponse;

@Controller
@RequestMapping(value="users")
public class AppUserController {

	@Autowired
	private UsersService usersService;
	
	@RequestMapping(value="detail")
	public UserResponse getUser(@RequestHeader String authorization) {
		return usersService.getUser(authorization);
	}
}
