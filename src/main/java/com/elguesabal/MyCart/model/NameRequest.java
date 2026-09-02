package com.elguesabal.MyCart.model;

import java.util.UUID;

public class NameRequest {
    private UUID	cartId;
	private Long	itemId;
	private String	name;

	public UUID getCartId() {
		return (this.cartId);
	}

	public void setCartId(UUID cartId) {
		this.cartId = cartId;
	}

	public Long getItemId() {
		return (this.itemId);
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return (this.name);
	}

	public void setName(String name) {
		this.name = name;
	}
}
