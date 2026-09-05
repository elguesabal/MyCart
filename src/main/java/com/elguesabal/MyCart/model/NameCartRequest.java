package com.elguesabal.MyCart.model;

import java.util.UUID;

public class NameCartRequest {
    private UUID	id;
	private String	name;

	public UUID getId() {
		return (this.id);
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return (this.name);
	}

	public void setName(String name) {
		this.name = name;
	}
}
