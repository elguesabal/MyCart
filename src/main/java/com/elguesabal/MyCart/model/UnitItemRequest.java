package com.elguesabal.MyCart.model;

import java.util.UUID;

/**
 * @author VAMPETA
 * @brief CLASSE RESPONSAVEL POR ARMAZENAR INFORMACOES DO BODY NA ROTA PATCH /item/unit
 * @param cartId ID DO CARRINHO
 * @param itemId ID DO ITEM
 * @param unit NOVA UNIDADE DE MEDIDA DO ITEM
*/
public class UnitItemRequest {
    private UUID	cartId;
	private Long	itemId;
	private String	unit;

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
	 * @brief GETTER DE this.unit
	*/
	public String getUnit() {
		return (this.unit);
	}

	/**
	 * @author VAMPETA
	 * @brief SETTER DE this.unit
	*/
	public void setUnit(String unit) {
		this.unit = unit;
	}
}
