package br.net.mirante.viewmodels.request;

import java.util.GregorianCalendar;
import java.util.List;

public class PersonViewModelRequest {

	private Long id;

	private String name;

	private String docNumber;

	private GregorianCalendar birthDate;

	private List<PhoneRequest> phones;

	private int type;

	private String motherName;

	private String fatherName;

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

	public List<PhoneRequest> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneRequest> phones) {
		this.phones = phones;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	
}
