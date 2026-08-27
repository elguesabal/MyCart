package com.elguesabal.MyCart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elguesabal.MyCart.model.CartItem;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/cart")
public class CartController {
	@GetMapping("/{id}")
	public String cart(@PathVariable("id") String id, Model model) {
		CartItem		item1 = new CartItem("Arroz", "kg");
		CartItem		item2 = new CartItem("Feijão", "kg");
		CartItem		item3 = new CartItem("Sabonete");
		List<CartItem>	items = new ArrayList<>();

		items.add(item1);
		items.add(item2);
		items.add(item3);
		model.addAttribute("id", id);
		model.addAttribute("items", items);
		return ("cart");
	}
}
