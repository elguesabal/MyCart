/**
 * @author VAMPETA
 * @brief SALVA O ANTIGO NOME ITEM
 * @param {Object} event OBJETO COM INFORMACOES DO EVENTO
 * @param {string} event.target.closest(".name-item").value SALVA O ANTIGO NOME DO PRODUTO
*/
function nameEditingItem(event) {
	const inputName = event.target.closest(".name-item");
	if (!inputName) return;

	inputName.dataset.originalValue = inputName.value;
}

/**
 * @author VAMPETA
 * @brief CAPTURA O NOVO NOME DO ITEM E ENVIA PARA O BACK END
 * @param {Object} event OBJETO COM INFORMACOES DO EVENTO
 * @param {string} event.target.closest(".name-item").dataset.itemId IDENTIFICADOR DO ITEM
 * @param {string} event.target.closest(".cart-list").dataset.cartId IDENTIFICADOR DO CARRINHO
 * @param {string} event.target.closest(".name-item").value NOVO NOME DO PRODUTO
*/
async function nameItem(event) {
	const inputName = event.target.closest(".name-item");
	if (!inputName) return;
	const cartList = inputName.closest(".cart-list");
	const cartId = cartList.dataset.cartId;
	const itemId = inputName.dataset.itemId;
	const originalName = inputName.dataset.originalValue;
	const name = inputName.value.trim();

	const res = await api({
		method: "PATCH",
		url: "/item/name",
		data: {
			cartId: cartId,
			itemId: itemId,
			name: name
		}
	});
	if (res.status !== 204) inputName.value = originalName;
}

document.querySelector(".cart-list").addEventListener("focus", nameEditingItem, true);
document.querySelector(".cart-list").addEventListener("blur", nameItem, true);