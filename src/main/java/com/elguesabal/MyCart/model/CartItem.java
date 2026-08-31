package com.elguesabal.MyCart.model;

public class CartItem {
	private int		id;
	private String  name;
	private int     quantity;
	private String	unit;
	private boolean checked;

	public CartItem(String name) {
		this.id = 0;
		this.name = name;
		this.quantity = 1;
		this.unit = null;
		this.checked = false;
	}

	public CartItem(String name, String unit) {
		this.id = 0;
		this.name = name;
		this.quantity = 1;
		this.unit = unit;
		this.checked = false;
	}

	public CartItem(int id, String name, int quantity, String unit, boolean checked) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
		this.checked = checked;
	}

	public CartItem(String name, int quantity, String unit, boolean checked) {
		this.id = 0;
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
		this.checked = checked;
	}


	public CartItem(String name, int quantity, boolean checked) {
		this.id = 0;
		this.name = name;
		this.quantity = quantity;
		this.unit = null;
		this.checked = checked;
	}

	public int getId() {
		return (this.id);
	}

	public void setId(int id) {
		this.id = id;
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

	public String getUnit() {
		return (this.unit);
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public boolean getChecked() {
		return (this.checked);
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
