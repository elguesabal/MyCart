package com.elguesabal.MyCart.model;

import java.util.UUID;
import jakarta.validation.constraints.NotNull;

/**
 * @author VAMPETA
 * @brief CLASSE RESPONSAVEL POR ARMAZENAR INFORMACOES DO BODY NA ROTA DELETE /cart/delete
 * @param id ID DO CARRINHO
*/
public class DeleteCartRequest {
	@NotNull
	private UUID	id;

	/**
	 * @author VAMPETA
	 * @brief CONSTRUCTOR DA CLASSE
	 * @param id ID DO CARRINHO
	*/
	public DeleteCartRequest(UUID id) {
		this.id = id;
	}

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
}
