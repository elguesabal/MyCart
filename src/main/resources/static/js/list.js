function checkItem(event) {
	const checkbox = event.target.closest(".check-item");

	if (!checkbox) return;
	const itemName = checkbox.dataset.itemName;
	alert(`Marcado/desmarcado ${itemName}`);
}

// function nameItem(event) {

// }

// function quantityItem(event) {

// }

// function unitItem(event) {

// }

function deleteItem(event) {
	const button = event.target.closest(".delete-item");

	if (!button) return;
	const itemName = button.dataset.itemName;
	alert(`Excluir ${itemName}`);
}

function addItem() {
	alert("item adicionado");
}

document.querySelector(".cart-list").addEventListener("click", checkItem);
document.querySelector(".cart-list").addEventListener("click", deleteItem);
document.querySelector("#add-item").addEventListener("click", addItem);
