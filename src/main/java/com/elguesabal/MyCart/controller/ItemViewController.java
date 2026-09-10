package com.elguesabal.MyCart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.ui.Model;
import jakarta.validation.Valid;

import com.elguesabal.MyCart.service.ItemService;
import com.elguesabal.MyCart.model.CartItem;
import com.elguesabal.MyCart.model.CreateItemRequest;

/**
 * @author VAMPETA
 * @brief CLASSE RESPONSAVEL POR GERENCIAR ROTAS DA API QUE RESPONDE COM FRAGMENTOS HTML
 * @param itemService SERVICO RESPONSAVEL PELA LOGICA DE NEGOCIO E MANIPULACAO DOS ITENS DO CARRINHO
*/
@Controller
@RequestMapping("/item")
public class ItemViewController {
	private final ItemService itemService;

	/**
	 * @author VAMPETA
	 * @brief CONSTRUTOR DA CLASSE
	 * @param itemService SERVICO RESPONSAVEL PELA LOGICA DE NEGOCIO E MANIPULACAO DOS ITENS DO CARRINHO
	*/
	public ItemViewController(ItemService itemService) {
		this.itemService = itemService;
	}

	/**
	 * @brief CRIA UM NOVO ITEM NO CARRINHO E ENVIA O FRAGMENTO HTML MONTADO
	 * @param body DADOS NECESSARIO PARA CRIACAO DO ITEM
	 * @param model MODELO UTILIZADO PARA RENDERIZACAO DO FRAGMENTO THYMELEAF
	 * @return FRAGMENTO HTML DO ITEM CRIADO
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/create")
	public String createItem(@Valid @RequestBody CreateItemRequest body, Model model) {
		CartItem cartItem = itemService.createItem(body.getCartId(), body.getName(), body.getQuantity(), body.getUnit(), body.getChecked());

		model.addAttribute("item", cartItem);
		return ("fragments/item-list :: item");
	}
}
