package com.elguesabal.MyCart.model;

public class CartItem {
	private String  name;
	private int     quantity;
	private boolean checked;

	public CartItem(String name) {
		this.name = name;
		this.quantity = 1;
		this.checked = false;
	}

	public String getName() {
		return (this.name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return (this.quantity);
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean getChecked() {
		return (this.checked);
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
