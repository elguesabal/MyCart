package com.elguesabal.MyCart.controller;

import com.elguesabal.MyCart.service.CartService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/login")
public class CartController {
	@Autowired
    private CartService cartService;

	@GetMapping
	public String login() {
		return (this.cartService.cart());
	}
}
