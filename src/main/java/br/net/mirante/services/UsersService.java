package br.net.mirante.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.net.mirante.entities.AppUser;
import br.net.mirante.repository.AppUserRepository;
import br.net.mirante.viewmodels.response.UserResponse;

@Component
public class UsersService {

	@Autowired
	private TokenService tokenService;

	@Autowired
	private AppUserRepository appUserRepository;

	public UserResponse getUser(String token) {
		String login = tokenService.getLoginByToken(token);
		AppUser appUser = appUserRepository.findByLogin(login);

		UserResponse userResponse = new UserResponse(appUser);

		return userResponse;

	}

}
