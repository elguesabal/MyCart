/**
 * @author VAMPETA
 * @brief COPIA O LINK DA LISTA ATUAL PARA A AREA DE TRANSFERENCIA
*/
async function copyUrl() {
	const copyCartButton = document.getElementById("copy-url");
	const cartId = copyCartButton.dataset.cartId;
	const link = `${window.location.origin}/cart/${cartId}`;

	await navigator.clipboard.writeText(link);
}

document.querySelector("#copy-url").addEventListener("click", copyUrl);