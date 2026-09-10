package com.elguesabal.MyCart.model;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * @author VAMPETA
 * @brief CLASSE RESPONSAVEL POR ARMAZENAR INFORMACOES DO BODY NA ROTA PATCH /item/name
 * @param cartId ID DO CARRINHO
 * @param itemId ID DO ITEM
 * @param name NOVO NOME DO ITEM
*/
public class NameItemRequest {
	@NotNull
    private UUID	cartId;
	@NotNull
	@Positive
	private Long	itemId;
	@NotBlank
	private String	name;

	/**
	 * @author VAMPETA
	 * @brief GETTER DE this.cartId
	*/
	public UUID getCartId() {
		return (this.cartId);
	}

	/**
	 * @author VAMPETA
	 * @brief SETTER DE this.cartId
	*/
	public void setCartId(UUID cartId) {
		this.cartId = cartId;
	}

	/**
	 * @author VAMPETA
	 * @brief GETTER DE this.itemId
	*/
	public Long getItemId() {
		return (this.itemId);
	}

	/**
	 * @author VAMPETA
	 * @brief SETTER DE this.itemId
	*/
	public void setItemId(Long itemId) {
		this.itemId = itemId;
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
