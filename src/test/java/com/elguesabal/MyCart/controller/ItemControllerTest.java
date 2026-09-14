package com.elguesabal.MyCart.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;

import com.elguesabal.MyCart.service.ItemService;
import com.elguesabal.MyCart.model.CheckedItemRequest;

/**
 * @author VAMPETA
 * @brief CLASE DE TESTE DA CLASSE ItemController
*/
@ExtendWith(MockitoExtension.class)
public class ItemControllerTest {
	@Mock
	private ItemService itemService;
	@InjectMocks
	private ItemController itemController;

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
		verify(itemService).updateChecked(cartId, itemId, checked);		// PRECISO DISSO?
	}
}
