package br.net.mirante.viewmodels.response;

import br.net.mirante.entities.AppUser;

public class UserResponse {
	
	private String login;
	
	private Long profileId;
	
	public UserResponse() {
		
	}
	
	public UserResponse(AppUser appUser) {
		this.login = appUser.getLogin();
		this.profileId = appUser.getProfile().getId();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}
	

}
