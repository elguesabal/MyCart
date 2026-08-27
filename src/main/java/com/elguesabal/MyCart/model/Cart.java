package com.elguesabal.MyCart.model;

import java.util.UUID;

public class Cart {
	private UUID	id;
	private String	name;
	private String	description;

	public Cart(UUID id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

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

	public String getDescription() {
		return (this.description);
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
