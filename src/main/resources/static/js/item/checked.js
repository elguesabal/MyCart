/**
 * @author VAMPETA
 * @brief CAPTURA O NOVO ESTADO DE MARCADO OU DESMARCADO E ENVIA PARA O BACK END
 * @param {Object} event OBJETO COM INFORMACOES DO EVENTO
 * @param {string} event.target.closest(".check-item").dataset.itemId IDENTIFICADOR DO ITEM
 * @param {string} event.target.closest(".cart-list").dataset.cartId IDENTIFICADOR DO CARRINHO
 * @param {boolean} event.target.closest(".check-item").checked NOVO ESTADO DO ITEM
*/
async function checkItem(event) {
	const checkbox = event.target.closest(".check-item");
	if (!checkbox) return;
	const cartList = checkbox.closest(".cart-list");
	const cartId = cartList.dataset.cartId;
	const itemId = checkbox.dataset.itemId;
	const checked = checkbox.checked;
	const res = await api({
		method: "PATCH",
		url: "/item/checked",
		data: {
			cartId: cartId,
			itemId: itemId,
			checked: checked
		}
	});

	if (res.status !== 204) {
		checkbox.checked = !checked;
		return;
	}
	updateCartStatus(cartList);
}

document.querySelector(".cart-list").addEventListener("click", checkItem);