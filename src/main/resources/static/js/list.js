const cartList = document.querySelector(".cart-list");

cartList.addEventListener("click", (event) => {
	const button = event.target.closest(".delete-item");

	if (!button) return;
	const itemName = button.dataset.itemName;
	alert(`Excluir ${itemName}`);
});