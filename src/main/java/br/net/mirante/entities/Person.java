package br.net.mirante.entities;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.net.mirante.viewmodels.request.PhoneRequest;

@Entity
@Table(name="person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="doc_number", nullable = false)
	private String docNumber;
	
	@Column(name="birth_date", nullable = false)
	private GregorianCalendar birthDate;
	
	@Column(name="creation_date", nullable = false)
	private GregorianCalendar creationDate;
	
	@Column(name="mother_name", nullable = true)
	private String motherName;
	
	@Column(name="father_name", nullable = true)
	private String fatherName;
	
	@Column(name="type", nullable=false)
	private int type;
	
	@OneToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
	private List<Phone> phones;

	
	public Person() {
		
	}
	
	public Person(
			String name, 
			String docNumber, 
			GregorianCalendar birthDate, 
			GregorianCalendar creationDate, 
			List<PhoneRequest> phonesRequest,
			int type,
			String motherName,
			String fatherName) {
		this.name = name;
		this.docNumber = docNumber;
		this.birthDate = birthDate;
		this.creationDate = creationDate;
		this.type = type;
		this.motherName = motherName;
		this.fatherName = fatherName;
		
		List<Phone> phones = new ArrayList<Phone>();
		
		for(PhoneRequest phoneRequest : phonesRequest) {
			Phone phone = new Phone(phoneRequest);
			phone.setCreationDate(new GregorianCalendar());
			phones.add(phone);
		}
		
		this.phones = phones;
		
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

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
