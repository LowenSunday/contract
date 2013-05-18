package org.sic.contract.entity;

import java.io.Serializable;

public class Company implements Serializable{

	private static final long serialVersionUID = 8206645592087116018L;
	
	private Long id;
	
	private String companyName;
	
	private String address;
	
	private String representative;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRepresentative() {
		return representative;
	}

	public void setRepresentative(String representative) {
		this.representative = representative;
	}

}
