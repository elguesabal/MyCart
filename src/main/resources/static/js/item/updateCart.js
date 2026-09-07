/**
 * @author VAMPETA
 * @brief ATUALIZA AS ESTATISTICAS DA LISTA
 * @param {Object} cartList OBJETO COM INFORMACOES DO NOVO CARRINHO
*/
function updateCartStatus(cartList) {
	const items = cartList.querySelectorAll(".cart-item");
	const checkedItems = cartList.querySelectorAll(".item-checkbox:checked");
	const countItems = items.length;
	const countChecked = checkedItems.length;
	const percentageChecked = (countItems === 0) ? 0 : Math.round((countChecked / countItems) * 100);

	document.querySelector("#count-items").textContent = countItems;
	document.querySelector("#count-checked").textContent = countChecked;
	document.querySelector("#percentage-checked").textContent = percentageChecked;
}