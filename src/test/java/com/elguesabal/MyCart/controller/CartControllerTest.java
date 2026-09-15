package com.elguesabal.MyCart.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.UUID;
import java.util.Map;

import com.elguesabal.MyCart.service.CartService;
import com.elguesabal.MyCart.model.Cart;
import com.elguesabal.MyCart.model.NameCartRequest;
import com.elguesabal.MyCart.model.DescriptionCartRequest;
import com.elguesabal.MyCart.model.DeleteCartRequest;

/**
 * @author VAMPETA
 * @brief CLASE DE TESTE DA CLASSE CartController
*/
@ExtendWith(MockitoExtension.class)
public class CartControllerTest {
	@Mock
	private CartService		cartService;
	@InjectMocks
	private CartController	cartController;

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO createCart PARA VER SE VAI SER RETORNADO STATUS 201
	*/
	@Test
	void shouldCreateCartSuccessfully() {
		UUID	cartId = UUID.randomUUID();
		Cart	cart = new Cart(cartId, "vampeta", "vampeta");

		when(cartService.createCart()).thenReturn(cart);
		ResponseEntity<Map<String, Object>> res = cartController.createCart();
		assertEquals(201, res.getStatusCode().value());
		assertEquals(cartId, res.getBody().get("id"));
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO createCart CASO LANCE UM ERRO
	*/
	@Test
	void shouldThrowExceptionWhenCreateCartFails() {
		when(cartService.createCart()).thenThrow(new RuntimeException());
		assertThrows(RuntimeException.class, () -> cartController.createCart());
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO name PARA VER SE VAI SER RETORNADO STATUS 204
	*/
	@Test
	void shouldReturnNoContentWhenNameSuccessfully() {
		UUID			cartId = UUID.randomUUID();
		String			name = "vampeta";
		NameCartRequest	body = new NameCartRequest(cartId, name);

		when(cartService.updateName(cartId, name)).thenReturn(true);
		ResponseEntity<Void> res = cartController.name(body);
		assertEquals(204, res.getStatusCode().value());
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO name PARA VER SE VAI SER RETORNADO STATUS 404
	*/
	@Test
	void shouldReturnNotFoundWhenUpdatingCartName() {
		UUID			cartId = UUID.randomUUID();
		String			name = "vampeta";
		NameCartRequest	body = new NameCartRequest(cartId, name);

		when(cartService.updateName(cartId, name)).thenReturn(false);
		ResponseEntity<Void> res = cartController.name(body);
		assertEquals(404, res.getStatusCode().value());
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO name CASO LANCE UM ERRO
	*/
	@Test
	void shouldThrowExceptionWhenUpdateNameFails() {
		UUID			cartId = UUID.randomUUID();
		String			name = "vampeta";
		NameCartRequest	body = new NameCartRequest(cartId, name);

		when(cartService.updateName(cartId, name)).thenThrow(new RuntimeException());
		assertThrows(RuntimeException.class, () -> cartController.name(body));
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO description PARA VER SE VAI SER RETORNADO STATUS 204
	*/
	@Test
	void shouldReturnNoContentWhenDescriptionSuccessfully() {
		UUID					cartId = UUID.randomUUID();
		String					description = "vampeta";
		DescriptionCartRequest	body = new DescriptionCartRequest(cartId, description);

		when(cartService.updateDescription(cartId, description)).thenReturn(true);
		ResponseEntity<Void> res = cartController.description(body);
		assertEquals(204, res.getStatusCode().value());
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO description PARA VER SE VAI SER RETORNADO STATUS 404
	*/
	@Test
	void shouldReturnNotFoundWhenUpdatingCartDescription() {
		UUID					cartId = UUID.randomUUID();
		String					description = "vampeta";
		DescriptionCartRequest	body = new DescriptionCartRequest(cartId, description);

		when(cartService.updateDescription(cartId, description)).thenReturn(false);
		ResponseEntity<Void> res = cartController.description(body);
		assertEquals(404, res.getStatusCode().value());
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO description CASO LANCE UM ERRO
	*/
	@Test
	void shouldThrowExceptionWhenUpdateDescriptionFails() {
		UUID					cartId = UUID.randomUUID();
		String					description = "vampeta";
		DescriptionCartRequest	body = new DescriptionCartRequest(cartId, description);

		when(cartService.updateDescription(cartId, description)).thenThrow(new RuntimeException());
		assertThrows(RuntimeException.class, () -> cartController.description(body));
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO delete PARA VER SE VAI SER RETORNADO STATUS 204
	*/
	@Test
	void shouldReturnNoContentWhenDeleteSuccessfully() {
		UUID				cartId = UUID.randomUUID();
		DeleteCartRequest	body = new DeleteCartRequest(cartId);

		when(cartService.deleteCart(cartId)).thenReturn(true);
		ResponseEntity<Void> res = cartController.delete(body);
		assertEquals(204, res.getStatusCode().value());
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO delete PARA VER SE VAI SER RETORNADO STATUS 404
	*/
	@Test
	void shouldReturnNotFoundWhenDeletingCart() {
		UUID				cartId = UUID.randomUUID();
		DeleteCartRequest	body = new DeleteCartRequest(cartId);

		when(cartService.deleteCart(cartId)).thenReturn(false);
		ResponseEntity<Void> res = cartController.delete(body);
		assertEquals(404, res.getStatusCode().value());
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO delete CASO LANCE UM ERRO
	*/
	@Test
	void shouldThrowExceptionWhenDeleteFails() {
		UUID				cartId = UUID.randomUUID();
		DeleteCartRequest	body = new DeleteCartRequest(cartId);

		when(cartService.deleteCart(cartId)).thenThrow(new RuntimeException());
		assertThrows(RuntimeException.class, () -> cartController.delete(body));
	}
}
