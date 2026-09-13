package com.elguesabal.MyCart.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
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

import com.elguesabal.MyCart.model.CartItem;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {
	@Mock
	private JdbcTemplate	jdbcTemplate;
	@InjectMocks
	private ItemService		itemService;

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO createItem PARA VER SE CartItem VAI SER MONTADO CORRETAMENTE
	*/
	@Test
	void shouldCreateItem() {
		UUID		cartId = UUID.randomUUID();
		String		name = "vampeta";
		int			quantity = 5;
		String		unit = "kg";
		boolean		checked = false;
		CartItem	cartItem = new CartItem(42, name, quantity, unit, checked);

		when(jdbcTemplate.queryForObject(
			anyString(),
			any(RowMapper.class),
			eq(cartId),
			eq(name),
			eq(quantity),
			eq(unit),
			eq(checked)
		)).thenReturn(cartItem);
		CartItem	res = itemService.createItem(cartId, name, quantity, unit, checked);
		assertEquals(cartItem, res);
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO createItem CASO jdbcTemplate.update LANCE UM ERRO
	*/
	@Test
	void shouldThrowWhenDatabaseFails() {
		UUID				cartId = UUID.randomUUID();
		String				name = "vampeta";
		int					quantity = 5;
		String				unit = "kg";
		boolean				checked = false;
		DataAccessException	exception = new DataAccessException("Database error") {};

		when(jdbcTemplate.queryForObject(
			anyString(),
			any(RowMapper.class),
			eq(cartId),
			eq(name),
			eq(quantity),
			eq(unit),
			eq(checked)
		)).thenThrow(exception);
		assertThrows(DataAccessException.class, () -> itemService.createItem(cartId, name, quantity, unit, checked));
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO updateChecked CASO jdbcTemplate.update RETORNE 1
	*/
	@Test
	void shouldUpdateChecked() {
		UUID	cartId = UUID.randomUUID();
		Long	itemId = 1L;
		boolean	checked = true;

		when(jdbcTemplate.update(
			anyString(),
			eq(checked),
			eq(itemId),
			eq(cartId)
		)).thenReturn(1);
		boolean	res = itemService.updateChecked(cartId, itemId, checked);
		assertTrue(res);
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO updateChecked CASO jdbcTemplate.update RETORNE 0
	*/
	@Test
	void shouldNotUpdateCheckedWhenItemDoesNotExist() {
		UUID	cartId = UUID.randomUUID();
		Long	itemId = 1L;
		boolean	checked = true;

		when(jdbcTemplate.update(
			anyString(),
			eq(checked),
			eq(itemId),
			eq(cartId)
		)).thenReturn(0);
		boolean	res = itemService.updateChecked(cartId, itemId, checked);
		assertFalse(res);
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO updateChecked CASO jdbcTemplate.update LANCE UM ERRO
	*/
	@Test
	void shouldThrowExceptionWhenUpdatingChecked() {
		UUID	cartId = UUID.randomUUID();
		Long	itemId = 1L;
		boolean	checked = true;

		when(jdbcTemplate.update(
			anyString(),
			eq(checked),
			eq(itemId),
			eq(cartId)
		)).thenThrow(new DataAccessException("Database error") {});
		assertThrows(DataAccessException.class, () -> itemService.updateChecked(cartId, itemId, checked));
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO updateName CASO jdbcTemplate.update RETORNE 1
	*/
	@Test
	void shouldUpdateName() {
		UUID	cartId = UUID.randomUUID();
		Long	itemId = 1L;
		String	name = "vampeta";

		when(jdbcTemplate.update(
			anyString(),
			eq(name),
			eq(itemId),
			eq(cartId)
		)).thenReturn(1);
		boolean	res = itemService.updateName(cartId, itemId, name);
		assertTrue(res);
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO updateName CASO jdbcTemplate.update RETORNE 0
	*/
	@Test
	void shouldNotUpdateNameWhenItemDoesNotExist() {
		UUID	cartId = UUID.randomUUID();
		Long	itemId = 1L;
		String	name = "vampeta";

		when(jdbcTemplate.update(
			anyString(),
			eq(name),
			eq(itemId),
			eq(cartId)
		)).thenReturn(0);
		boolean	res = itemService.updateName(cartId, itemId, name);
		assertFalse(res);
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO updateName CASO jdbcTemplate.update LANCE UM ERRO
	*/
	@Test
	void shouldThrowExceptionWhenUpdatingName() {
		UUID	cartId = UUID.randomUUID();
		Long	itemId = 1L;
		String	name = "vampeta";

		when(jdbcTemplate.update(
			anyString(),
			eq(name),
			eq(itemId),
			eq(cartId)
		)).thenThrow(new DataAccessException("Database error") {});
		assertThrows(DataAccessException.class, () -> itemService.updateName(cartId, itemId, name));
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO updateQuantity CASO jdbcTemplate.update RETORNE 1
	*/
	@Test
	void shouldUpdateQuantity() {
		UUID	cartId = UUID.randomUUID();
		Long	itemId = 1L;
		int		quantity = 42;

		when(jdbcTemplate.update(
			anyString(),
			eq(quantity),
			eq(itemId),
			eq(cartId)
		)).thenReturn(1);
		boolean	res = itemService.updateQuantity(cartId, itemId, quantity);
		assertTrue(res);
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO updateQuantity CASO jdbcTemplate.update RETORNE 0
	*/
	@Test
	void shouldNotUpdateQuantityWhenItemDoesNotExist() {
		UUID	cartId = UUID.randomUUID();
		Long	itemId = 1L;
		int		quantity = 42;

		when(jdbcTemplate.update(
			anyString(),
			eq(quantity),
			eq(itemId),
			eq(cartId)
		)).thenReturn(0);
		boolean	res = itemService.updateQuantity(cartId, itemId, quantity);
		assertFalse(res);
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO updateQuantity CASO jdbcTemplate.update LANCE UM ERRO
	*/
	@Test
	void shouldThrowExceptionWhenUpdatingQuantity() {
		UUID	cartId = UUID.randomUUID();
		Long	itemId = 1L;
		int		quantity = 42;

		when(jdbcTemplate.update(
			anyString(),
			eq(quantity),
			eq(itemId),
			eq(cartId)
		)).thenThrow(new DataAccessException("Database error") {});
		assertThrows(DataAccessException.class, () -> itemService.updateQuantity(cartId, itemId, quantity));
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO updateUnit CASO jdbcTemplate.update RETORNE 1
	*/
	@Test
	void shouldUpdateUnit() {
		UUID	cartId = UUID.randomUUID();
		Long	itemId = 1L;
		String	unit = "kg";

		when(jdbcTemplate.update(
			anyString(),
			eq(unit),
			eq(itemId),
			eq(cartId)
		)).thenReturn(1);
		boolean	res = itemService.updateUnit(cartId, itemId, unit);
		assertTrue(res);
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO updateUnit CASO jdbcTemplate.update RETORNE 0
	*/
	@Test
	void shouldNotUpdateUnitWhenItemDoesNotExist() {
		UUID	cartId = UUID.randomUUID();
		Long	itemId = 1L;
		String	unit = "kg";

		when(jdbcTemplate.update(
			anyString(),
			eq(unit),
			eq(itemId),
			eq(cartId)
		)).thenReturn(0);
		boolean	res = itemService.updateUnit(cartId, itemId, unit);
		assertFalse(res);
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO updateUnit CASO jdbcTemplate.update LANCE UM ERRO
	*/
	@Test
	void shouldThrowExceptionWhenUpdatingUnit() {
		UUID	cartId = UUID.randomUUID();
		Long	itemId = 1L;
		String	unit = "kg";

		when(jdbcTemplate.update(
			anyString(),
			eq(unit),
			eq(itemId),
			eq(cartId)
		)).thenThrow(new DataAccessException("Database error") {});
		assertThrows(DataAccessException.class, () -> itemService.updateUnit(cartId, itemId, unit));
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO deleteItem CASO jdbcTemplate.update RETORNE 1
	*/
	@Test
	void shouldDeleteItem() {
		UUID	cartId = UUID.randomUUID();
		Long	itemId = 1L;

		when(jdbcTemplate.update(
			anyString(),
			eq(itemId),
			eq(cartId)
		)).thenReturn(1);
		boolean	res = itemService.deleteItem(cartId, itemId);
		assertTrue(res);
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO deleteItem CASO jdbcTemplate.update RETORNE 0
	*/
	@Test
	void shouldNotDeleteItemWhenItemDoesNotExist() {
		UUID	cartId = UUID.randomUUID();
		Long	itemId = 1L;

		when(jdbcTemplate.update(
			anyString(),
			eq(itemId),
			eq(cartId)
		)).thenReturn(0);
		boolean	res = itemService.deleteItem(cartId, itemId);
		assertFalse(res);
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO deleteItem CASO jdbcTemplate.update LANCE UM ERRO
	*/
	@Test
	void shouldThrowExceptionWhenDeleteItem() {
		UUID	cartId = UUID.randomUUID();
		Long	itemId = 1L;

		when(jdbcTemplate.update(
			anyString(),
			eq(itemId),
			eq(cartId)
		)).thenThrow(new DataAccessException("Database error") {});
		assertThrows(DataAccessException.class, () -> itemService.deleteItem(cartId, itemId));
	}
}
