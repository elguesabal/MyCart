package com.elguesabal.MyCart.controller;

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
        CartItem    item = new CartItem(id);

        model.addAttribute("id", id);
        model.addAttribute("item", item);
        return ("cart");
    }
}
