package com.elguesabal.MyCart.service;

import com.elguesabal.MyCart.model.Cart;
import com.elguesabal.MyCart.model.CartItem;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartService {
	private final JdbcTemplate	jdbcTemplate;

	public CartService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Cart createCart() {
		String sql = """
				INSERT INTO carts (name, description)
				VALUES (?, ?)
				RETURNING id, name, description
				""";

		return (jdbcTemplate.queryForObject(
			sql,
			(res, rowNum) -> new Cart(
				res.getObject("id", UUID.class),
				res.getString("name"),
				res.getString("description")
			),
			"Minha lista",
			null
		));
	}

	public List<Cart> findAll() {
		String sql = """
				SELECT id, name, description
				FROM carts
				""";
		
		return (jdbcTemplate.query(
			sql,
			(res, rowNum) -> new Cart(
				res.getObject("id", java.util.UUID.class),
				res.getString("name"),
				res.getString("description")
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
			(res, rowNum) -> new Cart(
				res.getObject("id", java.util.UUID.class),
				res.getString("name"),
				res.getString("description")
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
			(res, rowNum) -> new CartItem(
                res.getInt("id"),
                res.getString("name"),
                res.getInt("quantity"),
                res.getString("unit"),
                res.getBoolean("checked")
			),
			java.util.UUID.fromString(id)
		));
	}
}
