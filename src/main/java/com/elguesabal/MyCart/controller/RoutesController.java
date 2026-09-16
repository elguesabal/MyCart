package com.elguesabal.MyCart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

import com.elguesabal.MyCart.model.Cart;
import com.elguesabal.MyCart.model.CartItem;
import com.elguesabal.MyCart.service.CartService;

/**
 * @author VAMPETA
 * @brief CLASSE RESPONSAVEL POR GERENCIAR ROTAS DA API QUE RESPONDE COM FRAGMENTOS HTML
 * @param cartService SERVICO RESPONSAVEL PELA LOGICA DE NEGOCIO E MANIPULACAO DO CARRINHO
*/
@Controller
public class RoutesController {
	private final CartService	cartService;

	/**
	 * @author VAMPETA
	 * @brief CONSTRUTOR DA CLASSE
	 * @param cartService SERVICO RESPONSAVEL PELA LOGICA DE NEGOCIO E MANIPULACAO DO CARRINHO
	*/
	public RoutesController(CartService cartService) {
		this.cartService = cartService;
	}

	/**
	 * @author VAMPETA
	 * @brief PAGINA PRINCIPAL DO SITE
	 * @param model MODELO UTILIZADO PARA RENDERIZACAO DO FRAGMENTO THYMELEAF
	*/
	@GetMapping("/")
	public String index(Model model) {
		Cart	cart = new Cart("Minhas compras", "Compras da semana");

		cart.addItem(new CartItem("Arroz", 2, "kg", true));
		cart.addItem(new CartItem("Leite", 3, "", false));
		cart.addItem(new CartItem("Café", 500, "g", false));
		cart.addItem(new CartItem("Ovos", 12, "", false));
		cart.addItem(new CartItem("Chocolate", 1, "", true));
		cart.addItem(new CartItem("Açucar", 1, "kg", false));
		cart.addItem(new CartItem("Coca-Cola", 2, "L", false));
		cart.addItem(new CartItem("Banana", 2, "kg", false));
		model.addAttribute("cart", cart);
        return ("index");
    }

	/**
	 * @author VAMPETA
	 * @brief PAGINA DE EXIBICAO DO CARRINHO
	 * @param id ID DO CARRINHO
	 * @param model MODELO UTILIZADO PARA RENDERIZACAO DO FRAGMENTO THYMELEAF
	*/
	@GetMapping("/cart/{id}")
	public String cart(@PathVariable("id") String id, Model model) {
		Cart	cart = cartService.findCart(id);

		cart.setItems(cartService.findItems(id));
		model.addAttribute("cart", cart);
		return ("cart");
	}
}
