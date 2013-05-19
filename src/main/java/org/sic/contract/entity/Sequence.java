package org.sic.contract.entity;

import java.io.Serializable;

public class Sequence implements Serializable{

	private static final long serialVersionUID = -2450020054948698094L;
	
	private String name;
	
	private Long value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

}
