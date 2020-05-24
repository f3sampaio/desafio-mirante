package br.net.mirante.services;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class TokenService {
	
	private final String TOKEN_PREFIX = "Bearer";
	static final String SECRET = "Mirante@010203";
	
	public String getLoginByToken(String token) {
		return Jwts.parser().setSigningKey(SECRET)
				.parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
				.getBody()
				.getSubject();
	}
	
}
