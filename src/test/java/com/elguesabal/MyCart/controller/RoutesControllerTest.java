package com.elguesabal.MyCart.controller;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import com.elguesabal.MyCart.service.CartService;
import com.elguesabal.MyCart.model.Cart;
import com.elguesabal.MyCart.model.CartItem;

/**
 * @author VAMPETA
 * @brief CLASE DE TESTE DA CLASSE RoutesController
*/
@ExtendWith(MockitoExtension.class)
public class RoutesControllerTest {
	@Mock
	private Model				model;
	@Mock
	private CartService			cartService;
	@InjectMocks 
	private RoutesController	routesController;

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO index PARA VER SE VAI SER RETORNADO A STRING "index"
	*/
	@Test
	void shouldReturnIndex() {
		String	res = routesController.index(model);

		assertEquals("index", res);
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO index PARA VER SE VAI INSERIR O cart NO model CORRETAMENTE
	*/
	@Test
	void shouldAddCartToModel() {
		routesController.index(model);
		ArgumentCaptor<Cart>	captor = ArgumentCaptor.forClass(Cart.class);
		verify(model).addAttribute(eq("cart"), captor.capture());
		Cart	cart = captor.getValue();
		assertEquals("Minhas compras", cart.getName());
		assertEquals("Compras da semana", cart.getDescription());
		assertEquals(8, cart.getItems().size());
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO cart PARA VER SE VAI SER RETORNADO A STRING "cart"
	*/
	@Test
	void shouldReturnCart() {
		UUID			cartId = UUID.randomUUID();
		Cart			cart = new Cart(cartId, "vampeta", "vampeta");
		List<CartItem>	items = List.of(
			new CartItem(1, "Arroz", 2, "kg", false),
			new CartItem(2, "Feijão", 3, "kg", false)
		);

		when(cartService.findCart(cartId.toString())).thenReturn(cart);
		when(cartService.findItems(cartId.toString())).thenReturn(items);
		String	res = routesController.cart(cartId.toString(), model);
		assertEquals("cart", res);
		assertEquals(items, cart.getItems());
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO cart CASO findCart LANCE UM ERRO
	*/
	@Test
	void shouldThrowExceptionWhenFindCartFails() {
		UUID	cartId = UUID.randomUUID();

		when(cartService.findCart(cartId.toString())).thenThrow(new RuntimeException());
		assertThrows(RuntimeException.class, () -> routesController.cart(cartId.toString(), model));
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO cart CASO findItems LANCE UM ERRO
	*/
	@Test
	void shouldThrowExceptionWhenFindItemsFails() {
		UUID	cartId = UUID.randomUUID();

		when(cartService.findItems(cartId.toString())).thenThrow(new RuntimeException());
		assertThrows(RuntimeException.class, () -> routesController.cart(cartId.toString(), model));
	}
}
