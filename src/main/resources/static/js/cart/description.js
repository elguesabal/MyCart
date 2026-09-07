/**
 * @author VAMPETA
 * @brief SALVA A ANTIGA DESCRICAO DO CARRINHO
 * @param {Object} event OBJETO COM INFORMACOES DO EVENTO
 * @param {string} event.target.closest("#cart-description").value SALVA A ANTIGA DESCRICAO DO PRODUTO
*/
function descriptionEditingCart(event) {
	const inputDescription = event.target.closest("#cart-description");
	if (!inputDescription) return;

	inputDescription.dataset.originalValue = inputDescription.value;
}

/**
 * @author VAMPETA
 * @brief CAPTURA A NOVA DESCRICAO DO CARRINHO E ENVIA PARA O BACK END
 * @param {Object} event OBJETO COM INFORMACOES DO EVENTO
 * @param {string} event.target.closest("#cart-description").dataset.cartId IDENTIFICADOR DO CARRINHO
 * @param {string} event.target.closest("#cart-description").value NOVA DESCRICAO DO CARRINHO
*/
async function updateDescriptionCart(event) {
	const inputDescription = event.target.closest("#cart-description");
	if (!inputDescription) return;
	const cartId = inputDescription.dataset.cartId;
	const originalDescription = inputDescription.dataset.originalValue;
	const description = inputDescription.value.trim();
	const res = await api({
		method: "PATCH",
		url: "/cart/description",
		data: {
			id: cartId,
			description: description
		}
	});

	if (res.status !== 204) inputDescription.value = originalDescription;
}

document.querySelector("#cart-description").addEventListener("focus", descriptionEditingCart);
document.querySelector("#cart-description").addEventListener("blur", updateDescriptionCart);