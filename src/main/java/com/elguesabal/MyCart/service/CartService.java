package com.elguesabal.MyCart.service;

import com.elguesabal.MyCart.model.Cart;
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
}
