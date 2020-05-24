package br.net.mirante.viewmodels.request;

import java.util.GregorianCalendar;

public class PersonViewModelRequest {
	
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String name;
	
	private String docNumber;
	
	private GregorianCalendar birthDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}

	public GregorianCalendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(GregorianCalendar birthDate) {
		this.birthDate = birthDate;
	}
	
	
}
