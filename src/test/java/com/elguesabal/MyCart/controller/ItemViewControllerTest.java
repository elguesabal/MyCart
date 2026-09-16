package com.elguesabal.MyCart.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import com.elguesabal.MyCart.model.CartItem;
import com.elguesabal.MyCart.model.CreateItemRequest;
import com.elguesabal.MyCart.service.ItemService;

/**
 * @author VAMPETA
 * @brief CLASE DE TESTE DA CLASSE ItemViewController
*/
@ExtendWith(MockitoExtension.class)
public class ItemViewControllerTest {
	@Mock
	private Model				model;
	@Mock
	private ItemService			itemService;
	@InjectMocks 
	private ItemViewController	itemViewController;

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO createItem PARA VER SE VAI SER RETORNADO A STRING "fragments/item-list :: item"
	*/
	@Test
	void shouldCreateItemSuccessfully() {
		UUID				cartId = UUID.randomUUID();
		CreateItemRequest	body = new CreateItemRequest(cartId, "vampeta", 42, "kg", false);
		CartItem			cartItem = new CartItem("vampeta", 42, "kg", false);
		
		when(itemService.createItem(cartId, "vampeta", 42, "kg", false)).thenReturn(cartItem);
		String	res = itemViewController.createItem(body, model);
		assertEquals("fragments/item-list :: item", res);
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO cart CASO createItem LANCE UM ERRO
	*/
	@Test
	void shouldThrowExceptionWhenCreateItemFails() {
		UUID				cartId = UUID.randomUUID();
		CreateItemRequest	body = new CreateItemRequest(cartId, "vampeta", 42, "kg", false);

		when(itemService.createItem(cartId, "vampeta", 42, "kg", false)).thenThrow(new RuntimeException());
		assertThrows(RuntimeException.class, () -> itemViewController.createItem(body, model));
	}
}
