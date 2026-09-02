package com.elguesabal.MyCart.model;

import java.util.UUID;

public class UnitRequest {
    private UUID	cartId;
	private Long	itemId;
	private String	unit;

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

	public String getUnit() {
		return (this.unit);
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
}
