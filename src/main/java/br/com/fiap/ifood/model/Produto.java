package br.com.fiap.ifood.model;

public class Produto {
	
	// Atributos
	private int cdProduto;
	private String nomeProduto;
	private float preco;
	
	
	// Construtor
	public Produto() {
	}


	// Getters & Setters
	public int getCdProduto() {
		return cdProduto;
	}


	public void setCdProduto(int cdProduto) {
		this.cdProduto = cdProduto;
	}


	public String getNomeProduto() {
		return nomeProduto;
	}


	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}


	public float getPreco() {
		return preco;
	}


	public void setPreco(float preco) {
		this.preco = preco;
	}
	

}