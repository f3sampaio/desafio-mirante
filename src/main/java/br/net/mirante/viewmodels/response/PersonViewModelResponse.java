package br.net.mirante.viewmodels.response;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import br.net.mirante.entities.Person;
import br.net.mirante.entities.Phone;

public class PersonViewModelResponse {
	private Long id;

	private String name;

	private String docNumber;

	private GregorianCalendar birthDate;
	
	private GregorianCalendar creationDate;
	
	private int type;
	
	private String motherName;
	
	private String fatherName;
	
	private List<PhoneResponse> phones;
	
	public PersonViewModelResponse() {
		
	}
	
	public PersonViewModelResponse(Person person) {
		this.id = person.getId();
		this.name = person.getName();
		this.docNumber = person.getDocNumber();
		this.birthDate = person.getBirthDate();
		this.creationDate = person.getCreationDate();
		this.motherName = person.getMotherName();
		this.fatherName = person.getFatherName();
		this.type = person.getType();
		
		List<PhoneResponse> listPhonesRsp = new ArrayList<PhoneResponse>();
		
		for(Phone phone : person.getPhones()) {
			listPhonesRsp.add(new PhoneResponse(phone));
		}
		
		this.phones = listPhonesRsp;
	}
	
	public PersonViewModelResponse(Long id, String name, String docNumber, GregorianCalendar birthDate) {
		this.id = id;
		this.name = name;
		this.docNumber = docNumber;
		this.birthDate = birthDate;
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

	public GregorianCalendar getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(GregorianCalendar creationDate) {
		this.creationDate = creationDate;
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

	public List<PhoneResponse> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneResponse> phones) {
		this.phones = phones;
	}

	
}
