package com.elguesabal.MyCart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elguesabal.MyCart.service.ItemService;
import com.elguesabal.MyCart.model.CartItem;
import com.elguesabal.MyCart.model.CreateItemRequest;
import com.elguesabal.MyCart.model.CheckedRequest;
import com.elguesabal.MyCart.model.NameRequest;
import com.elguesabal.MyCart.model.QuantityRequest;
import com.elguesabal.MyCart.model.UnitRequest;
import com.elguesabal.MyCart.model.DeleteItemRequest;

@RestController
@RequestMapping("/item")
public class ItemController {
	private final ItemService	itemService;

	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@PostMapping("/create")
	public ResponseEntity<CartItem> create(@RequestBody CreateItemRequest body) {
		CartItem	cartItem = itemService.createItem(body.getCartId());

		return (ResponseEntity.status(HttpStatus.CREATED).body(cartItem));
	}

	@PatchMapping("/checked")
	public ResponseEntity<Void> checked(@RequestBody CheckedRequest body) {
		boolean	update = itemService.updateChecked(body.getCartId(), body.getItemId(), body.getChecked());

		if (!update) return (ResponseEntity.notFound().build());
		return (ResponseEntity.noContent().build());
	}

	@PatchMapping("/name")
	public ResponseEntity<Void> name(@RequestBody NameRequest body) {
		boolean	update = itemService.updateName(body.getCartId(), body.getItemId(), body.getName());

		if (!update) return (ResponseEntity.notFound().build());
		return (ResponseEntity.noContent().build());
	}

	@PatchMapping("/quantity")
	public ResponseEntity<Void> quantity(@RequestBody QuantityRequest body) {
		boolean	update = itemService.updateQuantity(body.getCartId(), body.getItemId(), body.getQuantity());

		if (!update) return (ResponseEntity.notFound().build());
		return (ResponseEntity.noContent().build());
	}

	@PatchMapping("/unit")
	public ResponseEntity<Void> unit(@RequestBody UnitRequest body) {
		boolean	update = itemService.updateUnit(body.getCartId(), body.getItemId(), body.getUnit());

		if (!update) return (ResponseEntity.notFound().build());
		return (ResponseEntity.noContent().build());
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Void> delete(@RequestBody DeleteItemRequest body) {
		boolean	update = itemService.deleteItem(body.getCartId(), body.getItemId());

		if (!update) return (ResponseEntity.notFound().build());
		return (ResponseEntity.noContent().build());
	}
}
