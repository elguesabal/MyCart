package com.elguesabal.MyCart.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

@Controller
@RequestMapping("/cart")
public class CartController {
	private final CartService	cartService;

	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@GetMapping("/{id}")
	public String cart(@PathVariable("id") String id, Model model) {
		Cart	cart = cartService.findCart(id);

		cart.setItems(cartService.findItems(id));
		model.addAttribute("cart", cart);
		return ("cart");
	}

	@PostMapping("/create")
	public String createCart() {
		Cart	cart = cartService.createCart();

		return ("redirect:/cart/" + cart.getId());
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
}
