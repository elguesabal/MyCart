package com.elguesabal.MyCart.service;

import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.elguesabal.MyCart.model.CartItem;

@Service
public class ItemService {
	private final JdbcTemplate	jdbcTemplate;

	public ItemService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public CartItem createItem(UUID cartId) {
		String	sql = """
				INSERT INTO cart_items (cart_id, name, quantity, unit, checked)
				VALUES (?, ?, ?, ?, ?)
				RETURNING id, cart_id, name, quantity, unit, checked
				""";

		return (jdbcTemplate.queryForObject(
			sql,
			(res, rowNum) -> new CartItem(
				res.getInt("id"),
				res.getString("name"),
				res.getInt("quantity"),
				res.getString("unit"),
				res.getBoolean("checked")
			),
			cartId,
			"Produto",
			1,
			"",
			false
		));
	}

	public boolean updateChecked(UUID cartId, Long itemId, boolean checked) {
		String	sql = """
				UPDATE cart_items
				SET checked = ?
				WHERE id = ?
				AND cart_id = ?
				""";
		int		rows = jdbcTemplate.update(sql, checked, itemId, cartId);

		return (rows > 0);
	}

	public boolean updateName(UUID cartId, Long itemId, String name) {
		String	sql = """
				UPDATE cart_items
				SET name = ?
				WHERE id = ?
				AND cart_id = ?
				""";
		int		rows = jdbcTemplate.update(sql, name, itemId, cartId);

		return (rows > 0);
	}

	public boolean updateQuantity(UUID cartId, Long itemId, int quantity) {
		String	sql = """
				UPDATE cart_items
				SET quantity = ?
				WHERE id = ?
				AND cart_id = ?
				""";
		int		rows = jdbcTemplate.update(sql, quantity, itemId, cartId);

		return (rows > 0);
	}

	public boolean updateUnit(UUID cartId, Long itemId, String unit) {
		String	sql = """
				UPDATE cart_items
				SET unit = ?
				WHERE id = ?
				AND cart_id = ?
				""";
		int		rows = jdbcTemplate.update(sql, unit, itemId, cartId);

		return (rows > 0);
	}

	public boolean deleteItem(UUID cartId, Long itemId) {
		String	sql = """
				DELETE FROM cart_items
				WHERE id = ?
				AND cart_id = ?
				""";
		int		rows = jdbcTemplate.update(sql, itemId, cartId);

		return (rows > 0);
	}
}
