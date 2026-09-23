package com.elguesabal.MyCart.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.elguesabal.MyCart.model.Cart;
import com.elguesabal.MyCart.model.CartItem;
import com.elguesabal.MyCart.service.CartService;
import com.elguesabal.MyCart.service.ItemService;

/**
 * @author VAMPETA
 * @brief CLASE DE TESTE DA CLASSE ItemService
*/
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ItemServiceIntegrationTest {
	private Cart		cart;
	private CartItem	cartItem;
	@Autowired
	private CartService	cartService;
	@Autowired
	private ItemService	itemService;

	/**
	 * @author VAMPETA
	 * @brief CRIA O AMBIENTE DE TESTE
	*/
	@BeforeEach
	void createCart() {
		this.cart = this.cartService.createCart();
		this.cartItem = this.itemService.createItem(this.cart.getId(), "vampeta", 42, "kg", false);
	}

	/**
	 * @author VAMPETA
	 * @brief VOLTA O ESTADO DO BANCO DE DADOS AO ORIGINAL
	*/
	@AfterEach
	void deleteCart() {
		if (this.cart != null) {
			this.cartService.deleteCart(this.cart.getId());
		}
	}

	/**
	 * @author VAMPETA
	 * @brief VERIFICA SE O CARRINHO FOI CRIADO CORRETAMENTE COM createCart
	*/
	@Test
	void shouldCreateCart() {
		assertNotNull(this.cart);
		assertNotNull(this.cart.getId());
		assertEquals("Minha lista", this.cart.getName());
		assertEquals(null, this.cart.getDescription());
		assertNotNull(this.cart.getItems());
		assertTrue(this.cart.getItems().isEmpty());
	}

	/**
	 * @author VAMPETA
	 * @brief VERIFICA SE O ITEM FOI CRIADO CORRETAMENTE COM createItem
	*/
	@Test
	void shouldCreateItem() {
		assertNotNull(this.cartItem.getId());
		assertEquals("vampeta", this.cartItem.getName());
		assertEquals(42, this.cartItem.getQuantity());
		assertEquals("kg", this.cartItem.getUnit());
		assertEquals(false, this.cartItem.getChecked());
	}
}
