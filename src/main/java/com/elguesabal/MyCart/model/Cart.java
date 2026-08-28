package com.elguesabal.MyCart.model;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

// import com.elguesabal.MyCart.model.Cart;
// import com.elguesabal.MyCart.model.CartItem;

public class Cart {
	private UUID		id;
	private String		name;
	private String		description;
	private List<CartItem>	items;

	// public Cart(UUID id, String name, String description, List<Cart> items) {
	// 	this.id = id;
	// 	this.name = name;
	// 	this.description = description;
	// 	this.items = items;
	// }

	public Cart(UUID id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.items = new ArrayList<>();
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

	public List<CartItem> getItems() {
		return (this.items);
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}
}
