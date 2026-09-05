package com.elguesabal.MyCart.model;

import java.util.UUID;

public class DescriptionCartRequest {
    private UUID	id;
	private String	description;

	public UUID getId() {
		return (this.id);
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDescription() {
		return (this.description);
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
