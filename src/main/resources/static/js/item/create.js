/**
 * @author VAMPETA
 * @brief ADICIONA UM ITEM E FAZ A REQUISICAO PARA O BACK END
 * @param {Object} event OBJETO COM INFORMACOES DO EVENTO
*/
async function createItem(event) {
    const cartList = event.target.closest(".cart-list");
    const cartItems = cartList.querySelector("#cart-items");
    const emptyCart = cartList.querySelector("#empty-cart");
    const cartId = document.querySelector(".cart-list").dataset.cartId;
	const res = await api({
		method: "POST",
		url: "/item/create",
		data: {
			cartId: cartId,
			name: "Produto",
			quantity: 1,
			unit: "",
			checked: false
		}
	});

	if (res.status === 201) {
		cartList.querySelector("#cart-items").insertAdjacentHTML("beforeend", res.data);
		cartItems.classList.remove("hidden");
		emptyCart.classList.add("hidden");
		updateCartStatus(cartList);
	}
}

document.querySelector("#create-item").addEventListener("click", createItem);