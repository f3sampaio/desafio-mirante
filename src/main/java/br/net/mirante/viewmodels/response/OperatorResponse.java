package br.net.mirante.viewmodels.response;

import br.net.mirante.entities.Operator;

public class OperatorResponse {

	private Long id;
	
	private String name;

	private String login;


	private String profileName;
	
	public OperatorResponse() {
		
	}
	
	public OperatorResponse(Operator operator) {
		this.id = operator.getId();
		this.name = operator.getName();
		this.login = operator.getAppUser().getLogin();
		this.profileName = operator.getAppUser().getProfile().getTitle();
	}
	public OperatorResponse(Long id, String name, String login, String password, String profileName) {
		this.id = id;
		this.name = name;
		this.login = login;
		this.profileName = profileName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	
	
	
	
}
