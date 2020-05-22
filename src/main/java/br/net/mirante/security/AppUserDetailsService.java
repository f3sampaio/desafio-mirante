package br.net.mirante.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.net.mirante.entities.AppUser;
import br.net.mirante.repository.AppUserRepository;


@Component
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private AppUserRepository appUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		AppUser appUser = appUserRepository.findByLogin(login);
		
		if(appUser == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		
		Collection<GrantedAuthority> auths = new ArrayList<>();
		auths.add(new SimpleGrantedAuthority("USER"));
		org.springframework.security.core.userdetails.User userSpring = 
				new org.springframework.security.core.userdetails.User(appUser.getLogin(), appUser.getPassword(), auths); 
		
		return userSpring;
	}

	
}
