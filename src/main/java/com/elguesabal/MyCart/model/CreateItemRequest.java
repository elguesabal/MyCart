package com.elguesabal.MyCart.model;

import java.util.UUID;

public class CreateItemRequest {
	private UUID	cartId;
	private String	name;
	private int		quantity;
	private String	unit;
	private boolean	checked;

	/**
	 * @author VAMPETA
	 * @brief GETTER DE this.cartId
	*/
	public UUID getCartId() {
		return (this.cartId);
	}

	/**
	 * @author VAMPETA
	 * @brief SETTER DE this.cartId
	*/
	public void setCartId(UUID cartId) {
		this.cartId = cartId;
	}

	/**
	 * @author VAMPETA
	 * @brief GETTER DE this.name
	*/
	public String getName() {
		return (this.name);
	}

	/**
	 * @author VAMPETA
	 * @brief SETTER DE this.name
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @author VAMPETA
	 * @brief GETTER DE this.quantity
	*/
	public int getQuantity() {
		return (this.quantity);
	}

	/**
	 * @author VAMPETA
	 * @brief SETTER DE this.quantity
	*/
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @author VAMPETA
	 * @brief GETTER DE this.unit
	*/
	public String getUnit() {
		return (this.unit);
	}

	/**
	 * @author VAMPETA
	 * @brief SETTER DE this.unit
	*/
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * @author VAMPETA
	 * @brief GETTER DE this.checked
	*/
	public boolean getChecked() {
		return (this.checked);
	}

	/**
	 * @author VAMPETA
	 * @brief SETTER DE this.checked
	*/
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
