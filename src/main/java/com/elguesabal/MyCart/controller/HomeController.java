package com.elguesabal.MyCart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.elguesabal.MyCart.model.Cart;

import org.springframework.ui.Model;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home(Model model) {
		Cart	cart = new Cart("Minhas compras123", "Compras da semana");

		model.addAttribute("cart", cart);
		return ("index");
	}
}
