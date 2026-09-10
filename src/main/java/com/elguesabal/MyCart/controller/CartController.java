package com.elguesabal.MyCart.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import com.elguesabal.MyCart.model.Cart;
import com.elguesabal.MyCart.service.CartService;
import com.elguesabal.MyCart.model.NameCartRequest;
import com.elguesabal.MyCart.model.DescriptionCartRequest;
import com.elguesabal.MyCart.model.DeleteCartRequest;

/**
 * @author VAMPETA
 * @brief CLASSE RESPONSAVEL POR GERENCIAR ROTAS DA API QUE MANIPULAM O CARRINHO
 * @param cartService SERVICO RESPONSAVEL PELA LOGICA DE NEGOCIO E MANIPULACAO DO CARRINHO
*/
@RestController
@RequestMapping("/cart")
public class CartController {
	private final CartService	cartService;

	/**
	 * @author VAMPETA
	 * @brief CONSTRUTOR DA CLASSE
	 * @param cartService SERVICO RESPONSAVEL PELA LOGICA DE NEGOCIO E MANIPULACAO DO CARRINHO
	*/
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	/**
	 * @author VAMPETA
	 * @brief CRIA UM CARRINHO
	 * @return 201 RETORNA O ID DO CARRINHO CRIADO
	*/
	@PostMapping("/create")
	public ResponseEntity<Map<String, Object>> createCart() {
		Cart	cart = cartService.createCart();

		return (ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
			"id", cart.getId()
		)));
	}

	/**
	 * @author VAMPETA
	 * @brief ATUALIZA O NOME DO CARRINHO
	 * @param body DADOS NECESSARIO PARA ATUALIZACAO DO CARRINHO
	 * @return 204 RETORNA APENAS O STATUS SE ATUALIZADO COM SUCESSO
	 * @return 404 RETORNA APENAS O STATUS SE NAO ENCONTRAR O CARRINHO
	*/
	@PatchMapping ("/name")
	public ResponseEntity<Void> name(@Valid @RequestBody NameCartRequest body) {
		boolean	update = cartService.updateName(body.getId(), body.getName());

		if (!update) return (ResponseEntity.notFound().build());
		return (ResponseEntity.noContent().build());
	}

	/**
	 * @author VAMPETA
	 * @brief ATUALIZA A DESCRICAO DO CARRINHO
	 * @param body DADOS NECESSARIO PARA ATUALIZACAO DO CARRINHO
	 * @return 204 RETORNA APENAS O STATUS SE ATUALIZADO COM SUCESSO
	 * @return 404 RETORNA APENAS O STATUS SE NAO ENCONTRAR O CARRINHO
	*/
	@PatchMapping ("/description")
	public ResponseEntity<Void> description(@Valid @RequestBody DescriptionCartRequest body) {
		boolean	update = cartService.updateDescription(body.getId(), body.getDescription());

		if (!update) return (ResponseEntity.notFound().build());
		return (ResponseEntity.noContent().build());
	}

	/**
	 * @author VAMPETA
	 * @brief EXCLUI O CARRINHO
	 * @param body DADOS NECESSARIO PARA EXCLUIR O CARRINHO
	 * @return 204 RETORNA APENAS O STATUS SE EXCLUIDO COM SUCESSO
	 * @return 404 RETORNA APENAS O STATUS SE NAO ENCONTRAR O CARRINHO
	*/
	@DeleteMapping("/delete")
	public ResponseEntity<Void> delete(@Valid @RequestBody DeleteCartRequest body) {
		boolean	update = cartService.deleteCart(body.getId());

		if (!update) return (ResponseEntity.notFound().build());
		return (ResponseEntity.noContent().build());
	}
}
