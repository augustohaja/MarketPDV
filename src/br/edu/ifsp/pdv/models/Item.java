package br.edu.ifsp.pdv.models;

public class Item {
	private Long cod;
	private String descricao;
	private Integer quantidade;
	private Double precoUnitario;
	private Double subTotal;
	
	public Item(){
		
	}
	
	public Item(Long cod, String descricao, Integer quantidade, Double precoUnitario, Double subTotal) {
		super();
		this.cod = cod;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.subTotal = subTotal;
	}

	public Long getCod() {
		return cod;
	}

	public void setCod(Long cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	@Override
	public String toString() {
		return "Item [cod=" + cod + ", descricao=" + descricao + ", quantidade=" + quantidade + ", precoUnitario="
				+ precoUnitario + ", subTotal=" + subTotal + "]";
	}
}
