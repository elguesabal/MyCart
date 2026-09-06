package com.elguesabal.MyCart.model;

import java.util.UUID;

/**
 * @author VAMPETA
 * @brief CLASSE RESPONSAVEL POR ARMAZENAR INFORMACOES DO BODY NA ROTA PATCH /item/quantity
 * @param cartId ID DO CARRINHO
 * @param itemId ID DO ITEM
 * @param quantity NOVA QUANTIDADE DO ITEM
*/
public class QuantityItemRequest {
    private UUID	cartId;
	private Long	itemId;
	private int		quantity;

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
	 * @brief GETTER DE this.quantity
	*/
	public int getQuantity() {
		return (this.quantity);
	}

	/**
	 * @author VAMPETA
	 * @brief SETTER DE this.quantity
	*/
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
