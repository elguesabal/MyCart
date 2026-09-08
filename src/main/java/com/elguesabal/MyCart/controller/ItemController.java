package com.elguesabal.MyCart.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elguesabal.MyCart.service.ItemService;
import com.elguesabal.MyCart.model.CheckedItemRequest;
import com.elguesabal.MyCart.model.NameItemRequest;
import com.elguesabal.MyCart.model.QuantityItemRequest;
import com.elguesabal.MyCart.model.UnitItemRequest;
import com.elguesabal.MyCart.model.DeleteItemRequest;

/**
 * @author VAMPETA
 * @brief CLASSE RESPONSAVEL POR GERENCIAR ROTAS DA API QUE MANIPULAM OS ITEMS
 * @param itemService SERVICO RESPONSAVEL PELA LOGICA DE NEGOCIO E MANIPULACAO DOS ITEMS
*/
@RestController
@RequestMapping("/item")
public class ItemController {
	private final ItemService	itemService;

	/**
	 * @author VAMPETA
	 * @brief CONSTRUTOR DA CLASSE
	 * @param itemService SERVICO RESPONSAVEL PELA LOGICA DE NEGOCIO E MANIPULACAO DOS ITEMS
	*/
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	/**
	 * @author VAMPETA
	 * @brief ATUALIZA O ESTADO DE MARCADO OU DESMARCADO DO ITEM
	 * @param body DADOS NECESSARIO PARA ATUALIZACAO DO ITEM
	 * @return 204 RETORNA APENAS O STATUS SE ATUALIZADO COM SUCESSO
	 * @return 404 RETORNA APENAS O STATUS SE NAO ENCONTRAR O ITEM
	*/
	@PatchMapping("/checked")
	public ResponseEntity<Void> checked(@RequestBody CheckedItemRequest body) {
		boolean	update = itemService.updateChecked(body.getCartId(), body.getItemId(), body.getChecked());

		if (!update) return (ResponseEntity.notFound().build());
		return (ResponseEntity.noContent().build());
	}

	/**
	 * @author VAMPETA
	 * @brief ATUALIZA O NOME DO ITEM
	 * @param body DADOS NECESSARIO PARA ATUALIZACAO DO ITEM
	 * @return 204 RETORNA APENAS O STATUS SE ATUALIZADO COM SUCESSO
	 * @return 404 RETORNA APENAS O STATUS SE NAO ENCONTRAR O ITEM
	*/
	@PatchMapping("/name")
	public ResponseEntity<Void> name(@RequestBody NameItemRequest body) {
		boolean	update = itemService.updateName(body.getCartId(), body.getItemId(), body.getName());

		if (!update) return (ResponseEntity.notFound().build());
		return (ResponseEntity.noContent().build());
	}

	/**
	 * @author VAMPETA
	 * @brief ATUALIZA A QUANTIDADE DO ITEM
	 * @param body DADOS NECESSARIO PARA ATUALIZACAO DO ITEM
	 * @return 204 RETORNA APENAS O STATUS SE ATUALIZADO COM SUCESSO
	 * @return 404 RETORNA APENAS O STATUS SE NAO ENCONTRAR O ITEM
	*/
	@PatchMapping("/quantity")
	public ResponseEntity<Void> quantity(@RequestBody QuantityItemRequest body) {
		boolean	update = itemService.updateQuantity(body.getCartId(), body.getItemId(), body.getQuantity());

		if (!update) return (ResponseEntity.notFound().build());
		return (ResponseEntity.noContent().build());
	}

	/**
	 * @author VAMPETA
	 * @brief ATUALIZA A UNIDADE DE MEDIDA DO ITEM
	 * @param body DADOS NECESSARIO PARA ATUALIZACAO DO ITEM
	 * @return 204 RETORNA APENAS O STATUS SE ATUALIZADO COM SUCESSO
	 * @return 404 RETORNA APENAS O STATUS SE NAO ENCONTRAR O ITEM
	*/
	@PatchMapping("/unit")
	public ResponseEntity<Void> unit(@RequestBody UnitItemRequest body) {
		boolean	update = itemService.updateUnit(body.getCartId(), body.getItemId(), body.getUnit());

		if (!update) return (ResponseEntity.notFound().build());
		return (ResponseEntity.noContent().build());
	}

	/**
	 * @author VAMPETA
	 * @brief EXCLUI O ITEM
	 * @param body DADOS NECESSARIO PARA EXCLUIR O ITEM
	 * @return 204 RETORNA APENAS O STATUS SE EXCLUIDO COM SUCESSO
	 * @return 404 RETORNA APENAS O STATUS SE NAO ENCONTRAR O ITEM
	*/
	@DeleteMapping("/delete")
	public ResponseEntity<Void> delete(@RequestBody DeleteItemRequest body) {
		boolean	update = itemService.deleteItem(body.getCartId(), body.getItemId());

		if (!update) return (ResponseEntity.notFound().build());
		return (ResponseEntity.noContent().build());
	}
}
