package com.elguesabal.MyCart.model;

import java.util.UUID;

public class QuantityRequest {
    private UUID	cartId;
	private Long	itemId;
	private int		quantity;

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

	public int getQuantity() {
		return (this.quantity);
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
