package com.elguesabal.MyCart.model;

import java.util.UUID;

public class CheckedItemRequest {
	private UUID	cartId;
	private Long	itemId;
	private boolean	checked;

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

	public boolean getChecked() {
		return (this.checked);
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
