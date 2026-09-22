package com.elguesabal.MyCart.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.elguesabal.MyCart.model.Cart;
import com.elguesabal.MyCart.model.CartItem;
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
	@BeforeEach
	void createCart() {
		this.cart = this.cartService.createCart();
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
	 * @brief VERIFICA SE O CARRINHO FOI ENCONTRADO CORRETAMENTE COM findCart
	*/
	@Test
	void shouldFindCart() {
		Cart	cart = this.cartService.findCart(this.cart.getId());

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
	void shouldThrowExceptionWhenFindCartWithInvalidId() {
		assertThrows(EmptyResultDataAccessException.class, () -> this.cartService.findCart(UUID.randomUUID()));
	}

	/**
	 * @author VAMPETA
	 * @brief VERIFICA SE OS ITEMS SAO ENCONTRADO E RETORNADOS CORRETAMENTE DE findeItems
	*/
	@Test
	void shouldReturnEmptyListWhenCartHasNoItems() {
		List<CartItem>	items = this.cartService.findItems(this.cart.getId());

		assertNotNull(items);
		assertTrue(items.isEmpty());
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA SE findeItems RETORNA UMA LISTA VAZIA QUANDO NAO ENCONTRA UM CARRINHO PELO ID
	*/
	@Test
	void shouldReturnEmptyListWhenCartDoesNotExist() {
		List<CartItem>	items = this.cartService.findItems(UUID.randomUUID());

	    assertNotNull(items);
	    assertTrue(items.isEmpty());
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA SE O NAME DE CART FOI MODIFICADO COM SUCESSO COM updateName
	*/
	@Test
	void shouldUpdateCartName() {
		boolean	res = this.cartService.updateName(this.cart.getId(), "vampeta");

		assertTrue(res);
		Cart	cart = this.cartService.findCart(this.cart.getId());
		assertEquals("vampeta", cart.getName());
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA SE updateName RETORNA FALSE CASO O ID NAO EXISTA
	*/
	@Test
	void shouldReturnFalseWhenUpdatingCartNameWithInvalidId() {
		boolean	res = this.cartService.updateName(UUID.randomUUID(), "vampeta");

		assertFalse(res);
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA SE O DESCRIPTION DE CART FOI MODIFICADO COM SUCESSO COM updateDescription
	*/
	@Test
	void shouldUpdateCartDescription() {
		boolean	res = this.cartService.updateDescription(this.cart.getId(), "vampeta");

		assertTrue(res);
		Cart	cart = this.cartService.findCart(this.cart.getId());
		assertEquals("vampeta", cart.getDescription());
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA SE updateDescription RETORNA FALSE CASO O ID NAO EXISTA
	*/
	@Test
	void shouldReturnFalseWhenUpdatingCartDescriptionWithInvalidId() {
		boolean	res = this.cartService.updateDescription(UUID.randomUUID(), "vampeta");

		assertFalse(res);
	}
}
