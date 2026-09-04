package com.elguesabal.MyCart.model;

/**
 * @author VAMPETA
 * @brief CLASSE RESPONSAVEL POR ARMAZENAR INFORMACOES SOBRE UM ITEM
 * @param id ID DO ITEM
 * @param name NOME DO ITEM
 * @param quantity QUANTIDADE DO PRODUTO
 * @param unit UNIDADE DE MEDIDA USADA
 * @param checked MARCADO OU DESMARCADO
*/
public class CartItem {
	private int		id;
	private String	name;
	private int		quantity;
	private String	unit;
	private boolean	checked;

	/**
	 * @author VAMPETA
	 * @brief CONSTRUCTOR DA CLASSE
	 * @param id ID DO ITEM
	 * @param name NOME DO ITEM
	 * @param quantity QUANTIDADE DO ITEM
	 * @param unit UNIDADE DE MEDIDA DO ITEM
	 * @param checked INDICADOR DE MARCACAO DO ITEM
	*/
	public CartItem(int id, String name, int quantity, String unit, boolean checked) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
		this.checked = checked;
	}

	/**
	 * @author VAMPETA
	 * @brief CONSTRUCTOR DA CLASSE
	 * @param name NOME DO ITEM
	 * @param quantity QUANTIDADE DO ITEM
	 * @param unit UNIDADE DE MEDIDA DO ITEM
	 * @param checked INDICADOR DE MARCACAO DO ITEM
	*/
	public CartItem(String name, int quantity, String unit, boolean checked) {
		this.id = 0;
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
		this.checked = checked;
	}

	/**
	 * @author VAMPETA
	 * @brief CONSTRUCTOR DA CLASSE
	 * @param name NOME DO ITEM
	 * @param quantity QUANTIDADE DO ITEM
	 * @param checked INDICADOR DE MARCACAO DO ITEM
	*/
	public CartItem(String name, int quantity, boolean checked) {
		this.id = 0;
		this.name = name;
		this.quantity = quantity;
		this.unit = null;
		this.checked = checked;
	}

	/**
	 * @author VAMPETA
	 * @brief CONSTRUCTOR DA CLASSE
	 * @param name NOME DO ITEM
	 * @param unit UNIDADE DE MEDIDA DO ITEM
	*/
	public CartItem(String name, String unit) {
		this.id = 0;
		this.name = name;
		this.quantity = 1;
		this.unit = unit;
		this.checked = false;
	}

	/**
	 * @author VAMPETA
	 * @brief CONSTRUCTOR DA CLASSE
	 * @param name NOME DO ITEM
	*/
	public CartItem(String name) {
		this.id = 0;
		this.name = name;
		this.quantity = 1;
		this.unit = null;
		this.checked = false;
	}

	/**
	 * @author VAMPETA
	 * @brief GETTER DE this.id
	*/
	public int getId() {
		return (this.id);
	}

	/**
	 * @author VAMPETA
	 * @brief SETTER DE this.id
	*/
	public void setId(int id) {
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
	 * @brief GETTER DE this.quantity
	*/
	public int getQuantity() {
		return (this.quantity);
	}

	/**
	 * @author VAMPETA
	 * @brief SETTER DE this.quantity
	*/
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @author VAMPETA
	 * @brief GETTER DE this.unit
	*/
	public String getUnit() {
		return (this.unit);
	}

	/**
	 * @author VAMPETA
	 * @brief SETTER DE this.unit
	*/
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * @author VAMPETA
	 * @brief GETTER DE this.checked
	*/
	public boolean getChecked() {
		return (this.checked);
	}

	/**
	 * @author VAMPETA
	 * @brief SETTER DE this.checked
	*/
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
