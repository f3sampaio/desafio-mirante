package br.net.mirante.viewmodels.response;

import br.net.mirante.entities.Phone;

public class PhoneResponse {

	public String ddd;

	public String phone;

	public int type;

	public String getDdd() {
		return ddd;
	}

	public PhoneResponse() {

	}

	public PhoneResponse(Phone phone) {
		this.ddd = phone.getDdd();
		this.phone = phone.getPhone();
		this.type = phone.getType();
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

}
