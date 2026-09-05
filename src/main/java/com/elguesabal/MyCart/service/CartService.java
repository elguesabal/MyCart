package com.elguesabal.MyCart.service;

import com.elguesabal.MyCart.model.Cart;
import com.elguesabal.MyCart.model.CartItem;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author VAMPETA
 * @brief CLASSE RESPONSAVEL POR FAZER REQUISICOES SQL RELACIONADAS AO CARRINHO
 * @param jdbcTemplate OBJETO UTILIZADO PARA EXECUTAR CONSULTAS E OPERACOES SQL
*/
@Service
public class CartService {
	private final JdbcTemplate	jdbcTemplate;

	/**
	 * @author VAMPETA
	 * @brief CONSTRUCTOR DA CLASSE
	 * @param jdbcTemplate OBJETO UTILIZADO PARA EXECUTAR CONSULTAS E OPERACOES SQL
	*/
	public CartService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * @author VAMPETA
	 * @brief CRIA UM CARRINHO
	 * @return RETORNA AS INFORMACOES DO NOVO CARRINHO
	*/
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

	// public List<Cart> findAll() {
	// 	String sql = """
	// 			SELECT id, name, description
	// 			FROM carts
	// 			""";
		
	// 	return (jdbcTemplate.query(
	// 		sql,
	// 		(res, rowNum) -> new Cart(
	// 			res.getObject("id", UUID.class),
	// 			res.getString("name"),
	// 			res.getString("description")
	// 		)
	// 	));
	// }

	/**
	 * @author VAMPETA
	 * @brief BUSCA UM CARRINHO
	 * @param id ID DO CARRINHO
	 * @return RETORNA AS INFORMACOES DO CARRINHO
	*/
	public Cart findCart(String id) {
		String	sql = """
				SELECT id, name, description
				FROM carts
				WHERE id = ?
				""";
		
		return (jdbcTemplate.queryForObject(
			sql,
			(res, rowNum) -> new Cart(
				res.getObject("id", UUID.class),
				res.getString("name"),
				res.getString("description")
			),
			UUID.fromString(id)
		));
	}

	/**
	 * @author VAMPETA
	 * @brief BUSCA OS ITENS DE UM CARRINHO
	 * @param id ID DO CARRINHO
	 * @return RETORNA UMA LISTA DE ITEMS
	*/
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
			UUID.fromString(id)
		));
	}

	/**
	 * @author VAMPETA
	 * @brief ATUALIZA O NOME DO CARRINHO
	 * @param id ID DO CARRINHO
	 * @param name NOVO NOME DO CARRINHO
	 * @return RETORNA TRUE PARA SUCESSO
	 * @return RETORNA FALSE PARA ERRO
	*/
	public boolean updateName(UUID id, String name) {
		String	sql = """
				UPDATE carts
				SET name = ?
				WHERE id = ?
				""";
		int		rows = jdbcTemplate.update(sql, name, id);

		return (rows > 0);
	}

	/**
	 * @author VAMPETA
	 * @brief ATUALIZA A DESCRICAO DO CARRINHO
	 * @param id ID DO CARRINHO
	 * @param description NOVA DESCRICAO DO CARRINHO
	 * @return RETORNA TRUE PARA SUCESSO
	 * @return RETORNA FALSE PARA ERRO
	*/
	public boolean updateDescription(UUID id, String description) {
		String	sql = """
				UPDATE carts
				SET description = ?
				WHERE id = ?
				""";
		int		rows = jdbcTemplate.update(sql, description, id);

		return (rows > 0);
	}
}
