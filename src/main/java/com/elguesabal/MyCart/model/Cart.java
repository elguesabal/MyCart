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

	public Cart(String name, String description) {
		this.id = null;
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

	public void addItem(CartItem item) {
		this.items.add(item);
	}

	public int getCountItems() {
		return (this.items.size());		
	}

	public int getCountChecked() {
		int	count = 0;

		for (CartItem item : this.items) {
			if (item.getChecked()) count++;
		}
		return (count);
	}

	public int getPercentageChecked() {
		if (this.items.isEmpty()) return (0);
		return ((this.getCountChecked() * 100) / this.getCountItems());
	}
}
