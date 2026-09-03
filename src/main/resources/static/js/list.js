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

function nameEditing(event) {
	const inputName = event.target.closest(".name-item");
	if (!inputName) return;

	inputName.dataset.originalValue = inputName.value;
}

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

function quantityEditing(event) {
	const inputQuantity = event.target.closest(".quantity-item");

	if (!inputQuantity) return;
	inputQuantity.dataset.originalValue = inputQuantity.value;
}

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

function unitEditing(event) {
	const select = event.target.closest(".unit-item");

	if (!select) return;
	select.dataset.originalValue = select.value;
}

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

function addItem() {
	const cartList = document.querySelector(".cart-list");
	const cartItems = cartList.querySelector("#cart-items");
	const emptyCart = cartList.querySelector("#empty-cart");
	const item = document.createElement("div");

	item.className = "cart-item flex items-center gap-2 rounded-xl bg-gray-50 p-3 sm:gap-3 sm:p-4";
	item.innerHTML = `
		<label class="relative flex h-5 w-5 shrink-0 cursor-pointer items-center justify-center">
			<input
				class="check-item item-checkbox peer absolute h-5 w-5 cursor-pointer opacity-0"
				type="checkbox"
			/>
			<span class="flex h-5 w-5 items-center justify-center rounded-md border-2 border-gray-300 text-xs text-white transition peer-checked:border-blue-500 peer-checked:bg-blue-500">
				✓
			</span>
		</label>

		<input
			class="name-item min-w-0 flex-1 bg-transparent font-medium outline-none"
			type="text"
			placeholder="Nome do produto"
		/>

		<input
			class="quantity-item item-field w-12 shrink-0 bg-transparent text-right text-sm text-gray-400 outline-none sm:w-16"
			type="number"
			min="0"
			value="1"
		/>

		<select
			class="unit-item item-field w-14 shrink-0 bg-transparent text-sm text-gray-500 outline-none sm:w-16"
		>
			<option value=""></option>
			<option value="un">un</option>
			<option value="kg">kg</option>
			<option value="g">g</option>
			<option value="L">L</option>
			<option value="ml">ml</option>
		</select>

		<button
			class="delete-item flex h-8 w-8 shrink-0 cursor-pointer items-center justify-center rounded-lg text-gray-400 transition hover:bg-red-50 hover:text-red-600"
			type="button"
			title="Excluir produto"
			aria-label="Excluir produto"
		>
			🗑️
		</button>
	`;
	cartItems.appendChild(item);
	cartItems.classList.remove("hidden");
	emptyCart.classList.add("hidden");
	item.querySelector(".name-item").focus();
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
