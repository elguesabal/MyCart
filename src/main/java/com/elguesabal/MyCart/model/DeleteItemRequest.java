package com.elguesabal.MyCart.model;

import java.util.UUID;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * @author VAMPETA
 * @brief CLASSE RESPONSAVEL POR ARMAZENAR INFORMACOES DO BODY NA ROTA DELETE /item/delete
 * @param cartId ID DO CARRINHO
 * @param itemId ID DO ITEM
*/
public class DeleteItemRequest {
	@NotNull
    private UUID	cartId;
	@NotNull
	@Positive
	private Long	itemId;

	/**
	 * @author VAMPETA
	 * @brief CONSTRUCTOR DA CLASSE
	 * @param cartId ID DO CARRINHO
	 * @param itemId ID DO ITEM
	*/
	public DeleteItemRequest(UUID cartId, Long itemId) {
		this.cartId = cartId;
		this.itemId = itemId;
	}

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
}
