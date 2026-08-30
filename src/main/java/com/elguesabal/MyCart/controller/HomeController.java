package com.elguesabal.MyCart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.elguesabal.MyCart.model.Cart;
import com.elguesabal.MyCart.model.CartItem;

import org.springframework.ui.Model;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home(Model model) {
		Cart	cart = new Cart("Minhas compras", "Compras da semana");

		cart.addItem(new CartItem("Arroz", 2, "kg", true));
		cart.addItem(new CartItem("Leite", 3, false));
		cart.addItem(new CartItem("Café", 500, "g", false));
		cart.addItem(new CartItem("Ovos", 12, false));
		model.addAttribute("cart", cart);
		return ("index");
	}
}
