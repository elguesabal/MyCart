package com.elguesabal.MyCart.model;

import java.util.UUID;
import jakarta.validation.constraints.NotNull;

/**
 * @author VAMPETA
 * @brief CLASSE RESPONSAVEL POR ARMAZENAR INFORMACOES DO BODY NA ROTA PATCH /cart/description
 * @param id ID DO CARRINHO
 * @param description NOVA DESCRICAO DO CARRINHO
*/
public class DescriptionCartRequest {
	@NotNull
    private UUID	id;
	@NotNull
	private String	description;

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
	 * @brief GETTER DE this.description
	*/
	public String getDescription() {
		return (this.description);
	}

	/**
	 * @author VAMPETA
	 * @brief SETTER DE this.description
	*/
	public void setDescription(String description) {
		this.description = description;
	}
}
