package com.elguesabal.MyCart.model;

import java.util.UUID;

/**
 * @author VAMPETA
 * @brief CLASSE RESPONSAVEL POR ARMAZENAR INFORMACOES DO BODY NA ROTA PATCH /cart/name
 * @param id ID DO CARRINHO
 * @param name NOVO NOME DO CARRINHO
*/
public class NameCartRequest {
    private UUID	id;
	private String	name;

	/**
	 * @author VAMPETA
	 * @brief GETTER DE this.id
	*/
	public UUID getId() {
		return (this.id);
	}

	/**
	 * @author VAMPETA
	 * @brief SETTER DE this.id
	*/
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * @author VAMPETA
	 * @brief GETTER DE this.name
	*/
	public String getName() {
		return (this.name);
	}

	/**
	 * @author VAMPETA
	 * @brief SETTER DE this.name
	*/
	public void setName(String name) {
		this.name = name;
	}
}
