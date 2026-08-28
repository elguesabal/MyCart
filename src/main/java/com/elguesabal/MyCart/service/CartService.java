package com.elguesabal.MyCart.service;

import com.elguesabal.MyCart.model.Cart;
import com.elguesabal.MyCart.model.CartItem;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
	private final JdbcTemplate	jdbcTemplate;

	public CartService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Cart> findAll() {
		String sql = """
				SELECT id, name, description
				FROM carts
				""";
		
		return (jdbcTemplate.query(
			sql,
			(resultSet, rowNum) -> new Cart(
				resultSet.getObject("id", java.util.UUID.class),
				resultSet.getString("name"),
				resultSet.getString("description")
			)
		));
	}

	public Cart findId(String id) {
		String	sql = """
				SELECT id, name, description
				FROM carts
				WHERE id = ?
				""";
		
		return (jdbcTemplate.queryForObject(
			sql,
			(resultSet, rowNum) -> new Cart(
				resultSet.getObject("id", java.util.UUID.class),
				resultSet.getString("name"),
				resultSet.getString("description")
			),
			java.util.UUID.fromString(id)
		));
	}

	public List<CartItem> findItems(String id) {
		String	sql = """
				SELECT id, name, quantity, unit, checked
				FROM cart_items
				WHERE cart_id = ?
				""";

		return (jdbcTemplate.query(
			sql,
			(resultSet, rowNum) -> new CartItem(
                resultSet.getString("name"),
                resultSet.getInt("quantity"),
                resultSet.getString("unit"),
                resultSet.getBoolean("checked")
			),
			java.util.UUID.fromString(id)
		));
	}
}
