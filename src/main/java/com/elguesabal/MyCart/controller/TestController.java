package com.elguesabal.MyCart.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elguesabal.MyCart.model.Cart;
import com.elguesabal.MyCart.service.CartService;

@RestController
@RequestMapping("/test")
public class TestController {
	private final CartService	cartService;

	public TestController(CartService cartService) {
		this.cartService = cartService;
	}

	@GetMapping("/1")
	public List<Cart> test1() {
		List<Cart>	query = cartService.findAll();

		for (Cart cart : query) {
			System.out.println();
			System.out.println("id: " + cart.getId());
			System.out.println("name: " + cart.getName());
			System.out.println("description: " + cart.getDescription());
			System.out.println();
		}
		return (query);
	}

	@GetMapping("/2")
	public Cart test2() {
		Cart	query = cartService.findId("309ed6cf-b62c-4590-93d2-b8d438c9c631");

		System.out.println();
		System.out.println("id: " + query.getId());
		System.out.println("name: " + query.getName());
		System.out.println("description: " + query.getDescription());
		System.out.println();
		return (query);
	}
}
