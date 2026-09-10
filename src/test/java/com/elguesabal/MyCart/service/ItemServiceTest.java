package com.elguesabal.MyCart.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {
	@Mock 
	private JdbcTemplate	jdbcTemplate;
	@InjectMocks 
	private ItemService		itemService;

	@Test 
	void shouldUpdateChecked() {
		UUID	cartId = UUID.randomUUID();
		Long	itemId = 1L;
		boolean	checked = true;

		when(jdbcTemplate.update(
			anyString(),
			checked,
			itemId,
			cartId
		)).thenReturn(1);
		boolean	res = itemService.updateChecked(cartId, itemId, checked);
		assertTrue(res);
	}
}
