package br.edu.ifsp.pdv.models;

public class Produto {
	private Long cod;
	private String descricao;
	private Double precoUnitario;
	
	public Produto(){
		
	}
	
	public Produto(Long cod, String descricao, Double precoUnitario) {
		this.cod = cod;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
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

	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	@Override
	public String toString() {
		return "Produto [cod=" + cod + ", descricao=" + descricao + ", precoUnitario=" + precoUnitario + "]";
	}
}
