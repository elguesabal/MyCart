/**
 * @author VAMPETA
 * @brief CRIA UM CARRINHO
*/
async function createCart() {
	const res = await api({
		method: "POST",
		url: "/cart/create"
	});

	if (res.status === 201 && res.data.id) window.location.href = `/cart/${res.data.id}`;
}

document.querySelectorAll(".create-cart").forEach(element => {
	element.addEventListener("click", createCart);
});