package com.elguesabal.MyCart.service;

import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.elguesabal.MyCart.model.CartItem;

/**
 * @author VAMPETA
 * @brief CLASSE RESPONSAVEL POR FAZER REQUISICOES SQL RELACIONADAS AO ITEMS
 * @param jdbcTemplate OBJETO UTILIZADO PARA EXECUTAR CONSULTAS E OPERACOES SQL
*/
@Service
public class ItemService {
	private final JdbcTemplate	jdbcTemplate;

	/**
	 * @author VAMPETA
	 * @brief CONSTRUCTOR DA CLASSE
	 * @param jdbcTemplate OBJETO UTILIZADO PARA EXECUTAR CONSULTAS E OPERACOES SQL
	*/
	public ItemService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * @author VAMPETA
	 * @brief CRIA UM ITEM
	 * @param cartId ID DO CARRINHO
	 * @param name NOME DO ITEM
	 * @param quantity QUANTIDADE DO ITEM
	 * @param unit MEDIDA DE UNIDADE DO ITEM
	 * @param checked ESTADO DE MARCADO OU DESMARCADO DO ITEM
	 * @return RETORNA AS INFORMACOES DO NOVO ITEM
	*/
	public CartItem createItem(UUID cartId, String name, int quantity, String unit, boolean checked) {
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
			name,
			quantity,
			unit,
			checked
		));
	}

	/**
	 * @author VAMPETA
	 * @brief ATUALIZA O ESTADO DE MARCADO OU DESMACARDO DO ITEM
	 * @param cartId ID DO CARRINHO
	 * @param itemId ID DO ITEM
	 * @param checked ESTADO DE MARCADO OU DESMARCADO
	 * @return RETORNA TRUE PARA SUCESSO
	 * @return RETORNA FALSE PARA ERRO
	*/
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

	/**
	 * @author VAMPETA
	 * @brief ATUALIZA O NOME DO ITEM
	 * @param cartId ID DO CARRINHO
	 * @param itemId ID DO ITEM
	 * @param name NOVO NOME DO ITEM
	 * @return RETORNA TRUE PARA SUCESSO
	 * @return RETORNA FALSE PARA ERRO
	*/
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

	/**
	 * @author VAMPETA
	 * @brief ATUALIZA A QUANTIDADE DO ITEM
	 * @param cartId ID DO CARRINHO
	 * @param itemId ID DO ITEM
	 * @param quantity NOVA QUANTIDADE DO ITEM
	 * @return RETORNA TRUE PARA SUCESSO
	 * @return RETORNA FALSE PARA ERRO
	*/
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

	/**
	 * @author VAMPETA
	 * @brief ATUALIZA A UNIDADE DE MEDIDA DO ITEM
	 * @param cartId ID DO CARRINHO
	 * @param itemId ID DO ITEM
	 * @param unit NOVA UNIDADE DE MEDIDA DO ITEM
	 * @return RETORNA TRUE PARA SUCESSO
	 * @return RETORNA FALSE PARA ERRO
	*/
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

	/**
	 * @author VAMPETA
	 * @brief EXCLUI O ITEM DO BANCO DE DADOS
	 * @param cartId ID DO CARRINHO
	 * @param itemId ID DO ITEM
	 * @return RETORNA TRUE PARA SUCESSO
	 * @return RETORNA FALSE PARA ERRO
	*/
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
