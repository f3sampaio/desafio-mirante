package br.net.mirante.security;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private AppUserDetailsService appUserDetailsService;
	
	private static final String[] WHITELIST = {

	};
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors().configurationSource(this.corsConfigurationSource());
		httpSecurity.csrf().disable().authorizeRequests()
			.antMatchers(WHITELIST).permitAll()
			.antMatchers(HttpMethod.POST, "/users/login").permitAll()
			.anyRequest().authenticated()
			.and()
			
			// filtra requisições de login
			.addFilterBefore(new JWTLoginFilter("/users/login", authenticationManager()),
	                UsernamePasswordAuthenticationFilter.class)
			
			// filtra outras requisições para verificar a presença do JWT no header
			.addFilterBefore(new JWTAuthenticationFilter(),
	                UsernamePasswordAuthenticationFilter.class).cors().configurationSource(this.corsConfigurationSource());
			
			
			
	        
	}
	
// Essa configuração está habilitando o CORS da API pelo Spring Security, mas
// mas quando ativada, quebra o esquema do JWT!!! 
	CorsConfigurationSource corsConfigurationSource() {
	      final CorsConfiguration configuration = new CorsConfiguration();

	      configuration.setAllowedOrigins(Collections.singletonList("*"));
	      configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", 
	                                   "POST", "PUT", "DELETE", "PATCH"));
	      
	      configuration.setAllowCredentials(true);

	      configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
	      final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	      source.registerCorsConfiguration("/**", configuration);
	      return source;
	  }
	
	
	@Override
	  protected void configure(AuthenticationManagerBuilder builder) throws Exception {
	    builder
	        .userDetailsService(appUserDetailsService)
	        .passwordEncoder(new BCryptPasswordEncoder());
	  }
}
