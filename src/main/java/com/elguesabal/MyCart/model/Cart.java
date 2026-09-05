package com.elguesabal.MyCart.model;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

/**
 * @author VAMPETA
 * @brief CLASSE RESPONSAVEL POR ARMAZENAR INFORMACOES SOBRE UM CARRINHO
 * @param id ID DO CARRINHO
 * @param name NOME DO CARRINHO
 * @param description DESCRICAO DO CARRINHO
 * @param items LISTA COMNTENDO TODOS OS PRODUTOS DO CARRINHO
*/
public class Cart {
	private UUID			id;
	private String			name;
	private String			description;
	private List<CartItem>	items;

	/**
	 * @author VAMPETA
	 * @brief CONSTRUCTOR DA CLASSE
	 * @param id ID DO CARRINHO
	 * @param name NOME DO CARRINHO
	 * @param description DESCRICAO DO CARRINHO
	*/
	public Cart(UUID id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.items = new ArrayList<>();
	}

	/**
	 * @author VAMPETA
	 * @brief CONSTRUCTOR DA CLASSE
	 * @param id ID DO CARRINHO
	 * @param name NOME DO CARRINHO
	*/
	public Cart(String name, String description) {
		this.id = null;
		this.name = name;
		this.description = description;
		this.items = new ArrayList<>();
	}

	/**
	 * @author VAMPETA
	 * @brief GETTER DE this.id
	*/
	public UUID getId() {
		return (this.id);
	}

	/**
	 * @author VAMPETA
	 * @brief SETTER DE this.id
	*/
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * @author VAMPETA
	 * @brief GETTER DE this.name
	*/
	public String getName() {
		return (this.name);
	}

	/**
	 * @author VAMPETA
	 * @brief SETTER DE this.name
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @author VAMPETA
	 * @brief GETTER DE this.description
	*/
	public String getDescription() {
		return (this.description);
	}

	/**
	 * @author VAMPETA
	 * @brief SETTER DE this.description
	*/
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @author VAMPETA
	 * @brief GETTER DE this.items
	*/
	public List<CartItem> getItems() {
		return (this.items);
	}

	/**
	 * @author VAMPETA
	 * @brief SETTER DE this.items
	*/
	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	/**
	 * @author VAMPETA
	 * @brief ADICIONA UM ITEM A this.items
	 * @param item ITEM A SER ADICIONADO A LISTA
	*/
	public void addItem(CartItem item) {
		this.items.add(item);
	}

	/**
	 * @author VAMPETA
	 * @brief CONTA QUANTOS ITENS EXISTEM NA LISTA
	 * @return RETORNA A O TAMANHO DE this.items
	*/
	public int getCountItems() {
		return (this.items.size());		
	}

	/**
	 * @author VAMPETA
	 * @brief CONTA QUANTOS ITENS DE CartItem.checked SAO TRUE
	 * @return RETORNA QUANTOS ITEMS ESTAO MARCADOS
	*/
	public int getCountChecked() {
		int	count = 0;

		for (CartItem item : this.items) {
			if (item.getChecked()) count++;
		}
		return (count);
	}

	/**
	 * @author VAMPETA
	 * @brief FAZ UMA CONTA PARA SABER QUANTOS PERCENTO DOS ITEMS DE CartItem.checked SAO TRUE
	 * @return RETORNA A PERCENTAGEM DE ITENS MARCADOS
	*/
	public int getPercentageChecked() {
		if (this.items.isEmpty()) return (100);
		return ((this.getCountChecked() * 100) / this.getCountItems());
	}
}
