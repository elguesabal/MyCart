package com.elguesabal.MyCart.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.UUID;

import com.elguesabal.MyCart.service.ItemService;
import com.elguesabal.MyCart.model.CheckedItemRequest;
import com.elguesabal.MyCart.model.NameItemRequest;
import com.elguesabal.MyCart.model.QuantityItemRequest;
import com.elguesabal.MyCart.model.UnitItemRequest;
import com.elguesabal.MyCart.model.DeleteItemRequest;

/**
 * @author VAMPETA
 * @brief CLASE DE TESTE DA CLASSE ItemController
*/
@ExtendWith(MockitoExtension.class)
public class ItemControllerTest {
	@Mock
	private ItemService		itemService;
	@InjectMocks
	private ItemController	itemController;

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO checked PARA VER SE VAI SER RETORNADO STATUS 204
	*/
	@Test
	void shouldReturnNoContentWhenCheckedSuccessfully() {
		UUID				cartId = UUID.randomUUID();
		Long				itemId = 42L;
		boolean				checked = true;
		CheckedItemRequest	body = new CheckedItemRequest(cartId, itemId, checked);

		when(itemService.updateChecked(cartId, itemId, checked)).thenReturn(true);
		ResponseEntity<Void> res = itemController.checked(body);
		assertEquals(204, res.getStatusCode().value());
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO checked PARA VER SE VAI SER RETORNADO STATUS 404
	*/
	@Test
	void shouldReturnNotFoundWhenUpdatingItemChecked() {
		UUID				cartId = UUID.randomUUID();
		Long				itemId = 42L;
		boolean				checked = true;
		CheckedItemRequest	body = new CheckedItemRequest(cartId, itemId, checked);

		when(itemService.updateChecked(cartId, itemId, checked)).thenReturn(false);
		ResponseEntity<Void> res = itemController.checked(body);
		assertEquals(404, res.getStatusCode().value());
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO checked CASO LANCE UM ERRO
	*/
	@Test
	void shouldThrowExceptionWhenUpdateCheckedFails() {
		UUID				cartId = UUID.randomUUID();
		Long				itemId = 42L;
		boolean				checked = true;
		CheckedItemRequest	body = new CheckedItemRequest(cartId, itemId, checked);

		when(itemService.updateChecked(cartId, itemId, checked)).thenThrow(new RuntimeException());
		assertThrows(RuntimeException.class, () -> itemController.checked(body));
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO name PARA VER SE VAI SER RETORNADO STATUS 204
	*/
	@Test
	void shouldReturnNoContentWhenNameSuccessfully() {
		UUID			cartId = UUID.randomUUID();
		Long			itemId = 42L;
		String			name = "vampeta";
		NameItemRequest	body = new NameItemRequest(cartId, itemId, name);

		when(itemService.updateName(cartId, itemId, name)).thenReturn(true);
		ResponseEntity<Void> res = itemController.name(body);
		assertEquals(204, res.getStatusCode().value());
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO name PARA VER SE VAI SER RETORNADO STATUS 404
	*/
	@Test
	void shouldReturnNotFoundWhenUpdatingItemName() {
		UUID			cartId = UUID.randomUUID();
		Long			itemId = 42L;
		String			name = "vampeta";
		NameItemRequest	body = new NameItemRequest(cartId, itemId, name);

		when(itemService.updateName(cartId, itemId, name)).thenReturn(false);
		ResponseEntity<Void> res = itemController.name(body);
		assertEquals(404, res.getStatusCode().value());
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO name CASO LANCE UM ERRO
	*/
	@Test
	void shouldThrowExceptionWhenUpdateNameFails() {
		UUID			cartId = UUID.randomUUID();
		Long			itemId = 42L;
		String			name = "vampeta";
		NameItemRequest	body = new NameItemRequest(cartId, itemId, name);

		when(itemService.updateName(cartId, itemId, name)).thenThrow(new RuntimeException());
		assertThrows(RuntimeException.class, () -> itemController.name(body));
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO quantity PARA VER SE VAI SER RETORNADO STATUS 204
	*/
	@Test
	void shouldReturnNoContentWhenQuantitySuccessfully() {
		UUID				cartId = UUID.randomUUID();
		Long				itemId = 42L;
		int					quantity = 42;
		QuantityItemRequest	body = new QuantityItemRequest(cartId, itemId, quantity);

		when(itemService.updateQuantity(cartId, itemId, quantity)).thenReturn(true);
		ResponseEntity<Void> res = itemController.quantity(body);
		assertEquals(204, res.getStatusCode().value());
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO quantity PARA VER SE VAI SER RETORNADO STATUS 404
	*/
	@Test
	void shouldReturnNotFoundWhenUpdatingItemQuantity() {
		UUID				cartId = UUID.randomUUID();
		Long				itemId = 42L;
		int					quantity = 42;
		QuantityItemRequest	body = new QuantityItemRequest(cartId, itemId, quantity);

		when(itemService.updateQuantity(cartId, itemId, quantity)).thenReturn(false);
		ResponseEntity<Void> res = itemController.quantity(body);
		assertEquals(404, res.getStatusCode().value());
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO quantity CASO LANCE UM ERRO
	*/
	@Test
	void shouldThrowExceptionWhenUpdateQuantityFails() {
		UUID				cartId = UUID.randomUUID();
		Long				itemId = 42L;
		int					quantity = 42;
		QuantityItemRequest	body = new QuantityItemRequest(cartId, itemId, quantity);

		when(itemService.updateQuantity(cartId, itemId, quantity)).thenThrow(new RuntimeException());
		assertThrows(RuntimeException.class, () -> itemController.quantity(body));
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO unit PARA VER SE VAI SER RETORNADO STATUS 204
	*/
	@Test
	void shouldReturnNoContentWhenUnitSuccessfully() {
		UUID			cartId = UUID.randomUUID();
		Long			itemId = 42L;
		String			unit = "kg";
		UnitItemRequest	body = new UnitItemRequest(cartId, itemId, unit);

		when(itemService.updateUnit(cartId, itemId, unit)).thenReturn(true);
		ResponseEntity<Void> res = itemController.unit(body);
		assertEquals(204, res.getStatusCode().value());
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO unit PARA VER SE VAI SER RETORNADO STATUS 404
	*/
	@Test
	void shouldReturnNotFoundWhenUpdatingItemUnit() {
		UUID			cartId = UUID.randomUUID();
		Long			itemId = 42L;
		String			unit = "kg";
		UnitItemRequest	body = new UnitItemRequest(cartId, itemId, unit);

		when(itemService.updateUnit(cartId, itemId, unit)).thenReturn(false);
		ResponseEntity<Void> res = itemController.unit(body);
		assertEquals(404, res.getStatusCode().value());
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO unit CASO LANCE UM ERRO
	*/
	@Test
	void shouldThrowExceptionWhenUpdateUnitFails() {
		UUID			cartId = UUID.randomUUID();
		Long			itemId = 42L;
		String			unit = "kg";
		UnitItemRequest	body = new UnitItemRequest(cartId, itemId, unit);

		when(itemService.updateUnit(cartId, itemId, unit)).thenThrow(new RuntimeException());
		assertThrows(RuntimeException.class, () -> itemController.unit(body));
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO delete PARA VER SE VAI SER RETORNADO STATUS 204
	*/
	@Test
	void shouldReturnNoContentWhenDeleteSuccessfully() {
		UUID				cartId = UUID.randomUUID();
		Long				itemId = 42L;
		DeleteItemRequest	body = new DeleteItemRequest(cartId, itemId);

		when(itemService.deleteItem(cartId, itemId)).thenReturn(true);
		ResponseEntity<Void> res = itemController.delete(body);
		assertEquals(204, res.getStatusCode().value());
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO delete PARA VER SE VAI SER RETORNADO STATUS 404
	*/
	@Test
	void shouldReturnNotFoundWhenDeletingItem() {
		UUID				cartId = UUID.randomUUID();
		Long				itemId = 42L;
		DeleteItemRequest	body = new DeleteItemRequest(cartId, itemId);

		when(itemService.deleteItem(cartId, itemId)).thenReturn(false);
		ResponseEntity<Void> res = itemController.delete(body);
		assertEquals(404, res.getStatusCode().value());
	}

	/**
	 * @author VAMPETA
	 * @brief TESTA O METODO delete CASO LANCE UM ERRO
	*/
	@Test
	void shouldThrowExceptionWhenDeleteFails() {
		UUID				cartId = UUID.randomUUID();
		Long				itemId = 42L;
		DeleteItemRequest	body = new DeleteItemRequest(cartId, itemId);

		when(itemService.deleteItem(cartId, itemId)).thenThrow(new RuntimeException());
		assertThrows(RuntimeException.class, () -> itemController.delete(body));
	}
}
