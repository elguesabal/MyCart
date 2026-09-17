package com.elguesabal.MyCart.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.elguesabal.MyCart.model.Cart;
import com.elguesabal.MyCart.service.CartService;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CartServiceIntegrationTest {
	private Cart		cart;
	@Autowired
	private CartService	cartService;

	@BeforeAll
	void createCart() {
		this.cart = this.cartService.createCart();
	}

	@AfterAll
	void deleteCart() {
		this.cartService.deleteCart(this.cart.getId());
	}

	@Test
	void shouldCreateCart() {
		assertNotNull(this.cart);
		assertNotNull(this.cart.getId());
		assertEquals("Minha lista", this.cart.getName());
		assertEquals(null, this.cart.getDescription());
	}
}
