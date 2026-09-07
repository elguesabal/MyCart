/**
 * @author VAMPETA
 * @brief SALVA A ANTIGA QUANTIDADE DO ITEM
 * @param {Object} event OBJETO COM INFORMACOES DO EVENTO
 * @param {string} event.target.closest(".quantity-item").value SALVA A ANTIGA QUANTIDADE DO PRODUTO
*/
function quantityEditingItem(event) {
	const inputQuantity = event.target.closest(".quantity-item");

	if (!inputQuantity) return;
	inputQuantity.dataset.originalValue = inputQuantity.value;
}

/**
 * @author VAMPETA
 * @brief CAPTURA A NOVA QUANTIDADE DO ITEM E ENVIA PARA O BACK END
 * @param {Object} event OBJETO COM INFORMACOES DO EVENTO
 * @param {string} event.target.closest(".quantity-item").dataset.itemId IDENTIFICADOR DO ITEM
 * @param {string} event.target.closest(".cart-list").dataset.cartId IDENTIFICADOR DO CARRINHO
 * @param {string} event.target.closest(".quantity-item").value NOVA QUANTIDADE DO PRODUTO
*/
async function quantityItem(event) {
	const inputQuantity = event.target.closest(".quantity-item");
	if (!inputQuantity) return;
	const cartList = inputQuantity.closest(".cart-list");
	const cartId = cartList.dataset.cartId;
	const itemId = inputQuantity.dataset.itemId;
	const originalQuantity = Number(inputQuantity.dataset.originalValue);
	const quantity = Number(inputQuantity.value);

	const res = await api({
		method: "PATCH",
		url: "/item/quantity",
		data: {
			cartId: cartId,
			itemId: itemId,
			quantity: quantity
		}
	});
	if (res.status !== 204) inputQuantity.value = originalQuantity;
}

document.querySelector(".cart-list").addEventListener("focus", quantityEditingItem, true);
document.querySelector(".cart-list").addEventListener("change", quantityItem);