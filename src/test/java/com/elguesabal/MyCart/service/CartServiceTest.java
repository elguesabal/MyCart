package com.elguesabal.MyCart.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.elguesabal.MyCart.model.Cart;

/**
 * @author VAMPETA
 * @brief CLASE DE TESTE DA CLASSE CartService
*/
@ExtendWith(MockitoExtension.class)
public class CartServiceTest {
	@Mock
	private JdbcTemplate	jdbcTemplate;
	@InjectMocks
	private CartService		cartService;

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO createCart PARA VER SE Cart VAI SER MONTADO CORRETAMENTE
	*/
	@Test
	void shouldCreateCart() {
		UUID	cartId = UUID.randomUUID();
		String	name = "Minha lista";
		String	description = "";
		Cart	cart = new Cart(cartId, name, description);

		when(jdbcTemplate.queryForObject(
			anyString(),
			any(RowMapper.class),
			eq("Minha lista"),
			isNull()
		)).thenReturn(cart);
		Cart	res = cartService.createCart();
		assertEquals(cart, res);
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO createCart CASO jdbcTemplate.update LANCE UM ERRO
	*/
	@Test
	void shouldThrowExceptionWhenCreatingCart() {
		DataAccessException	exception = new DataAccessException("Database error") {};

		when(jdbcTemplate.queryForObject(
			anyString(),
			any(RowMapper.class),
			eq("Minha lista"),
			isNull()
		)).thenThrow(exception);
		assertThrows(DataAccessException.class, () -> cartService.createCart());
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO findCart PARA VER SE Cart VAI SER MONTADO CORRETAMENTE
	*/
	void shouldFindCart() {
		UUID	cartId = UUID.randomUUID();
		String	name = "vampeta";
		String	description = "vampeta";
		Cart	cart = new Cart(cartId, name, description);

		when(jdbcTemplate.queryForObject(
			anyString(),
			any(RowMapper.class),
			eq(cartId)
		)).thenReturn(cart);
		Cart	res = cartService.findCart(cartId);
		assertEquals(cart, res);
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO findCart CASO jdbcTemplate.update LANCE UM ERRO
	*/
	@Test
	void shouldThrowExceptionWhenFindingCart() {
		UUID	cartId = UUID.randomUUID();
		DataAccessException	exception = new DataAccessException("Database error") {};

		when(jdbcTemplate.queryForObject(
			anyString(),
			any(RowMapper.class),
			eq(cartId)
		)).thenThrow(exception);
		assertThrows(DataAccessException.class, () -> cartService.findCart(cartId));
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO updateName CASO jdbcTemplate.update RETORNE 1
	*/
	@Test
	void shouldUpdateName() {
		UUID	cartId = UUID.randomUUID();
		String	name = "vampeta";

		when(jdbcTemplate.update(
			anyString(),
			eq(name),
			eq(cartId)
		)).thenReturn(1);
		boolean	res = cartService.updateName(cartId, name);
		assertTrue(res);
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO updateName CASO jdbcTemplate.update RETORNE 0
	*/
	@Test
	void shouldNotUpdateNameWhenItemDoesNotExist() {
		UUID	cartId = UUID.randomUUID();
		String	name = "vampeta";

		when(jdbcTemplate.update(
			anyString(),
			eq(name),
			eq(cartId)
		)).thenReturn(0);
		boolean	res = cartService.updateName(cartId, name);
		assertFalse(res);
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO updateName CASO jdbcTemplate.update LANCE UM ERRO
	*/
	@Test
	void shouldThrowExceptionWhenUpdatingName() {
		UUID	cartId = UUID.randomUUID();
		String	name = "vampeta";

		when(jdbcTemplate.update(
			anyString(),
			eq(name),
			eq(cartId)
		)).thenThrow(new DataAccessException("Database error") {});
		assertThrows(DataAccessException.class, () -> cartService.updateName(cartId, name));
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO updateDescrption CASO jdbcTemplate.update RETORNE 1
	*/
	@Test
	void shouldUpdateDescrption() {
		UUID	cartId = UUID.randomUUID();
		String	description = "vampeta";

		when(jdbcTemplate.update(
			anyString(),
			eq(description),
			eq(cartId)
		)).thenReturn(1);
		boolean	res = cartService.updateDescription(cartId, description);
		assertTrue(res);
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO updateDescrption CASO jdbcTemplate.update RETORNE 0
	*/
	@Test
	void shouldNotUpdateDescrptionWhenItemDoesNotExist() {
		UUID	cartId = UUID.randomUUID();
		String	description = "vampeta";

		when(jdbcTemplate.update(
			anyString(),
			eq(description),
			eq(cartId)
		)).thenReturn(0);
		boolean	res = cartService.updateDescription(cartId, description);
		assertFalse(res);
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO updateDescrption CASO jdbcTemplate.update LANCE UM ERRO
	*/
	@Test
	void shouldThrowExceptionWhenUpdatingDescrption() {
		UUID	cartId = UUID.randomUUID();
		String	description = "vampeta";

		when(jdbcTemplate.update(
			anyString(),
			eq(description),
			eq(cartId)
		)).thenThrow(new DataAccessException("Database error") {});
		assertThrows(DataAccessException.class, () -> cartService.updateDescription(cartId, description));
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO deleteCart CASO jdbcTemplate.update RETORNE 1
	*/
	@Test
	void shouldDeleteCart() {
		UUID	cartId = UUID.randomUUID();

		when(jdbcTemplate.update(
			anyString(),
			eq(cartId)
		)).thenReturn(1);
		boolean	res = cartService.deleteCart(cartId);
		assertTrue(res);
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO deleteCart CASO jdbcTemplate.update RETORNE 0
	*/
	@Test
	void shouldNotDeleteCartWhenItemDoesNotExist() {
		UUID	cartId = UUID.randomUUID();

		when(jdbcTemplate.update(
			anyString(),
			eq(cartId)
		)).thenReturn(0);
		boolean	res = cartService.deleteCart(cartId);
		assertFalse(res);
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO deleteCart CASO jdbcTemplate.update LANCE UM ERRO
	*/
	@Test
	void shouldThrowExceptionWhenDeleteCart() {
		UUID	cartId = UUID.randomUUID();

		when(jdbcTemplate.update(
			anyString(),
			eq(cartId)
		)).thenThrow(new DataAccessException("Database error") {});
		assertThrows(DataAccessException.class, () -> cartService.deleteCart(cartId));
	}
}
