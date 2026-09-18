package com.elguesabal.MyCart.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.elguesabal.MyCart.model.Cart;
import com.elguesabal.MyCart.service.CartService;

/**
 * @author VAMPETA
 * @brief CLASE DE TESTE DA CLASSE CartService
*/
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CartServiceIntegrationTest {
	private Cart		cart;
	@Autowired
	private CartService	cartService;

	/**
	 * @author VAMPETA
	 * @brief CRIA O AMBIENTE DE TESTE
	*/
	@BeforeAll
	void createCart() {
		this.cart = this.cartService.createCart();
	}

	/**
	 * @author VAMPETA
	 * @brief VOLTA O ESTADO DO BANCO DE DADOS AO ORIGINAL
	*/
	@AfterAll
	void deleteCart() {
		this.cartService.deleteCart(this.cart.getId());
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
	 * @brief VERIFICA SE O CARRINHO FOI ENCONTRADO CORRETAMENTE COM findCart
	*/
	@Test
	void shouldFindCart() {
		Cart	cart = cartService.findCart(this.cart.getId());

		assertNotNull(cart);
		assertEquals(this.cart.getId(), cart.getId());
		assertEquals("Minha lista", cart.getName());
		assertEquals(null, cart.getDescription());
		assertNotNull(cart.getItems());
		assertTrue(cart.getItems().isEmpty());
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA SE findCart LANCA UM ERRO QUANDO O ID NAO EXISTE
	*/
	@Test
	void shouldThrowExceptionWhenCartDoesNotExist() {
		assertThrows(EmptyResultDataAccessException.class, () -> cartService.findCart(UUID.randomUUID()));
	}
}
