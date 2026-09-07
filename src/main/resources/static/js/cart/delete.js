/**
 * @author VAMPETA
 * @brief EXCLUI UM CARRINHO
 * @param {Object} event OBJETO COM INFORMACOES DO EVENTO
 * @param {string} event.target.closest("#cart-name").dataset.cartId IDENTIFICADOR DO CARRINHO
 * @param {string} event.target.closest("#cart-name").value NOVA DESCRICAO DO CARRINHO
*/
async function deleteCart(event) {
	const inputDescription = event.target.closest("#delete-cart");
	if (!inputDescription) return;
	const cartId = inputDescription.dataset.cartId;
	const res = await api({
		method: "DELETE",
		url: "/cart/delete",
		data: {
			id: cartId
		}
	});

	if (res.status === 204) window.location.href = "/";
}

document.querySelector("#delete-cart").addEventListener("click", deleteCart);