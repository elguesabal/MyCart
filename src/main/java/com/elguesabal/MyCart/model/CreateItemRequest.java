package com.elguesabal.MyCart.model;

import java.util.UUID;

public class CreateItemRequest {
	private UUID	cartId;

	public UUID getCartId() {
		return (this.cartId);
	}

	public void setCartId(UUID cartId) {
		this.cartId = cartId;
	}
}
