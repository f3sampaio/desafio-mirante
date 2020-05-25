package br.net.mirante.entities;

import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.net.mirante.viewmodels.request.PhoneRequest;

@Entity
@Table(name="phone")
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="ddd", nullable = false, length = 3)
	private String ddd;
	
	@Column(name="phone", nullable = false, length = 10)
	private String phone;
	
	@Column(name="type", nullable = false)
	private int type;
	
	@Column(name="creation_date", nullable = false )
	private GregorianCalendar creationDate;

	public Phone() {
		
	}
	
	public Phone(PhoneRequest phoneRequest) {
		this.ddd = phoneRequest.getDdd();
		this.phone = phoneRequest.getPhone();
		this.type = phoneRequest.getType();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public GregorianCalendar getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(GregorianCalendar creationDate) {
		this.creationDate = creationDate;
	}
	
	
	
}
