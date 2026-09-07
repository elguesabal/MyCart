/**
 * @author VAMPETA
 * @brief SALVA O ANTIGO NOME DO CARRINHO
 * @param {Object} event OBJETO COM INFORMACOES DO EVENTO
 * @param {string} event.target.closest("#cart-name").value SALVA O ANTIGO NOME DO CARRINHO
*/
function nameEditingCart(event) {
	const inputName = event.target.closest("#cart-name");
	if (!inputName) return;

	inputName.dataset.originalValue = inputName.value;
}

/**
 * @author VAMPETA
 * @brief CAPTURA O NOVO NOME DO CARRINHO E ENVIA PARA O BACK END
 * @param {Object} event OBJETO COM INFORMACOES DO EVENTO
 * @param {string} event.target.closest("#cart-name").dataset.cartId IDENTIFICADOR DO CARRINHO
 * @param {string} event.target.closest("#cart-name").value NOVO NOME DO CARRINHO
*/
async function updateNameCart(event) {
	const inputName = event.target.closest("#cart-name");
	if (!inputName) return;
	const cartId = inputName.dataset.cartId;
	const originalName = inputName.dataset.originalValue;
	const name = inputName.value.trim();
	const res = await api({
		method: "PATCH",
		url: "/cart/name",
		data: {
			id: cartId,
			name: name
		}
	});

	if (res.status !== 204) inputName.value = originalName;
}

document.querySelector("#cart-name").addEventListener("focus", nameEditingCart);
document.querySelector("#cart-name").addEventListener("blur", updateNameCart);