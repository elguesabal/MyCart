package com.elguesabal.MyCart.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.elguesabal.MyCart.model.Cart;
import com.elguesabal.MyCart.service.CartService;
import com.elguesabal.MyCart.model.NameCartRequest;
import com.elguesabal.MyCart.model.DescriptionCartRequest;
import com.elguesabal.MyCart.model.DeleteCartRequest;

@Controller
@RequestMapping("/cart")
public class CartController {
	private final CartService	cartService;

	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@PostMapping("/create")
	public ResponseEntity<Map<String, Object>> createCart() {
		Cart	cart = cartService.createCart();

		return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
			"id", cart.getId()
		));
	}

	@GetMapping("/{id}")
	public String cart(@PathVariable("id") String id, Model model) {
		Cart	cart = cartService.findCart(id);

		cart.setItems(cartService.findItems(id));
		model.addAttribute("cart", cart);
		return ("cart");
	}

	@PatchMapping ("/name")
	public ResponseEntity<Void> name(@RequestBody NameCartRequest body) {
		boolean	update = cartService.updateName(body.getId(), body.getName());

		if (!update) return (ResponseEntity.notFound().build());
		return (ResponseEntity.noContent().build());
	}

	@PatchMapping ("/description")
	public ResponseEntity<Void> description(@RequestBody DescriptionCartRequest body) {
		boolean	update = cartService.updateDescription(body.getId(), body.getDescription());

		if (!update) return (ResponseEntity.notFound().build());
		return (ResponseEntity.noContent().build());
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Void> delete(@RequestBody DeleteCartRequest body) {
		boolean	update = cartService.deleteCart(body.getId());

		if (!update) return (ResponseEntity.notFound().build());
		return (ResponseEntity.noContent().build());
	}
}
