package com.elguesabal.MyCart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class ListController {
	private String[] items = { "Sabonete", "Arroz", "Carne", "Batata" };

    @GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("items", items);
		return ("list");
	}
}
