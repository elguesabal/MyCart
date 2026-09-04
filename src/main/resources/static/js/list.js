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

	if (res.status !== 204) checkbox.checked = !checked;
}

/**
 * @author VAMPETA
 * @brief SALVA O TANTIGO NOME
 * @param {Object} event OBJETO COM INFORMACOES DO EVENTO
 * @param {string} event.target.closest(".name-item").value SALVA O ANTIGO NOME DO PRODUTO
*/
function nameEditing(event) {
	const inputName = event.target.closest(".name-item");
	if (!inputName) return;

	inputName.dataset.originalValue = inputName.value;
}

/**
 * @author VAMPETA
 * @brief CAPTURA O NOVO NOME E ENVIA PARA O BACK END
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

/**
 * @author VAMPETA
 * @brief 
 * @param {Object} event OBJETO COM INFORMACOES DO EVENTO
 * @param {string} event.target.closest(".quantity-item").value SALVA A ANTIGA QUANTIDADE DO PRODUTO
*/
function quantityEditing(event) {
	const inputQuantity = event.target.closest(".quantity-item");

	if (!inputQuantity) return;
	inputQuantity.dataset.originalValue = inputQuantity.value;
}

/**
 * @author VAMPETA
 * @brief CAPTURA A NOVA QUANTIDADE E ENVIA PARA O BACK END
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

/**
 * @author VAMPETA
 * @brief 
 * @param {Object} event OBJETO COM INFORMACOES DO EVENTO
 * @param {string} event.target.closest(".unit-item").value SALVA A ANTIGA UNIDADE DE MEDIDA DO ITEM
*/
function unitEditing(event) {
	const select = event.target.closest(".unit-item");

	if (!select) return;
	select.dataset.originalValue = select.value;
}

/**
 * @author VAMPETA
 * @brief CAPTURA A NOVA UNIDADE DE MEDIDA E ENVIA PARA O BACK END
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

	if (res.status !== 204) {
		alert("Erro ao excluir item");
		return;
	}
	buttonDelete.closest(".cart-item").remove();
	if (cartList.querySelectorAll(".cart-item").length === 0) {
		document.querySelector("#cart-items").classList.add("hidden");
		document.querySelector("#empty-cart").classList.remove("hidden");
	}
}

/**
 * @author VAMPETA
 * @brief ADICIONA UM ITEM E FAZ A REQUISICAO PARA O BACK END
 * @param {Object} event OBJETO COM INFORMACOES DO EVENTO
*/
async function addItem(event) {
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
	}
}

document.querySelector(".cart-list").addEventListener("click", checkItem);
document.querySelector(".cart-list").addEventListener("focus", nameEditing, true);
document.querySelector(".cart-list").addEventListener("blur", nameItem, true);
document.querySelector(".cart-list").addEventListener("focus", quantityEditing, true);
document.querySelector(".cart-list").addEventListener("change", quantityItem);
document.querySelector(".cart-list").addEventListener("focus", unitEditing, true);
document.querySelector(".cart-list").addEventListener("change", unitItem);
document.querySelector(".cart-list").addEventListener("click", deleteItem);
document.querySelector("#add-item").addEventListener("click", addItem);
