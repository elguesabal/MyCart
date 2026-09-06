package com.elguesabal.MyCart.model;

import java.util.UUID;

/**
 * @author VAMPETA
 * @brief CLASSE RESPONSAVEL POR ARMAZENAR INFORMACOES DO BODY NA ROTA PATCH /item/checked
 * @param cartId ID DO CARRINHO
 * @param itemId ID DO ITEM
 * @param checked INDICADOR SE O ITEM ESTA MARCADO OU DESMARCADO
*/
public class CheckedItemRequest {
	private UUID	cartId;
	private Long	itemId;
	private boolean	checked;

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
	 * @brief SETTER DE this.cartId
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
	 * @brief GETTER DE this.checked
	*/
	public boolean getChecked() {
		return (this.checked);
	}

	/**
	 * @author VAMPETA
	 * @brief SETTER DE this.checked
	*/
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
