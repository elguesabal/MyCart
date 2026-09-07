/**
 * @author VAMPETA
 * @brief SALVA A ANTIGA UNIDADE DE MEDIDA DO ITEM
 * @param {Object} event OBJETO COM INFORMACOES DO EVENTO
 * @param {string} event.target.closest(".unit-item").value SALVA A ANTIGA UNIDADE DE MEDIDA DO ITEM
*/
function unitEditingItem(event) {
	const select = event.target.closest(".unit-item");

	if (!select) return;
	select.dataset.originalValue = select.value;
}

/**
 * @author VAMPETA
 * @brief CAPTURA A NOVA UNIDADE DE MEDIDA DO ITEM E ENVIA PARA O BACK END
 * @param {Object} event OBJETO COM INFORMACOES DO EVENTO
 * @param {string} event.target.closest(".unit-item").dataset.itemId IDENTIFICADOR DO ITEM
 * @param {string} event.target.closest(".cart-list").dataset.cartId IDENTIFICADOR DO CARRINHO
 * @param {string} event.target.closest(".unit-item").value NOVA UNIDADE DE MEDIDA DO ITEM
*/
async function unitItem(event) {
	const select = event.target.closest(".unit-item");
	if (!select) return;
	const cartList = select.closest(".cart-list");
	const cartId = cartList.dataset.cartId;
	const itemId = select.dataset.itemId;
	const originalUnit = select.dataset.originalValue;
	const unit = select.value;
	const res = await api({
		method: "PATCH",
		url: "/item/unit",
		data: {
			cartId: cartId,
			itemId: itemId,
			unit: unit
		}
	});

	if (res.status !== 204) select.value = originalUnit;
}

document.querySelector(".cart-list").addEventListener("focus", unitEditingItem, true);
document.querySelector(".cart-list").addEventListener("change", unitItem);