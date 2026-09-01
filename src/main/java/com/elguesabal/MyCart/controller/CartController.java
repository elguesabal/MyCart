package com.elguesabal.MyCart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elguesabal.MyCart.model.Cart;
import com.elguesabal.MyCart.service.CartService;


import org.springframework.ui.Model;

@Controller
@RequestMapping("/cart")
public class CartController {
	private final CartService	cartService;

	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@GetMapping("/{id}")
	public String cart(@PathVariable("id") String id, Model model) {
		Cart	cart = cartService.findId(id);

		cart.setItems(cartService.findItems(id));
		model.addAttribute("id", id);
		model.addAttribute("cart", cart);
		return ("cart");
	}

	@PostMapping("/create")
	public String createCart() {
		Cart	cart = cartService.createCart();

		return ("redirect:/cart/" + cart.getId());
	}
}
