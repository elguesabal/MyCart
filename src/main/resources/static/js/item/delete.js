/**
 * @author VAMPETA
 * @brief DELETA UM ITEM E FAZ A REQUISICAO PARA O BACK END
 * @param {Object} event OBJETO COM INFORMACOES DO EVENTO
 * @param {string} event.target.closest(".delete-item").dataset.itemId IDENTIFICADOR DO ITEM
 * @param {string} event.target.closest(".cart-list").dataset.cartId IDENTIFICADOR DO CARRINHO
*/
async function deleteItem(event) {
	const buttonDelete = event.target.closest(".delete-item");
	if (!buttonDelete) return;
	const cartList = buttonDelete.closest(".cart-list");
	const cartId = cartList.dataset.cartId;
	const itemId = buttonDelete.dataset.itemId;
	const res = await api({
		method: "DELETE",
		url: "/item/delete",
		data: {
			cartId: cartId,
			itemId: itemId,
		}
	});

	if (res.status !== 204) return;
	buttonDelete.closest(".cart-item").remove();
	updateCartStatus(cartList);
	if (cartList.querySelectorAll(".cart-item").length === 0) {
		document.querySelector("#cart-items").classList.add("hidden");
		document.querySelector("#empty-cart").classList.remove("hidden");
	}
}

document.querySelector(".cart-list").addEventListener("click", deleteItem);