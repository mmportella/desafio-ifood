package br.com.fiap.ifood.model;

public class Pedido {
	
	
	// Atributos
	private long cdPedido;
	private String enderecoEntrega;
	private float valorPedido;
	private float valorTaxa;
	
	
	// Construtor
	public Pedido() {
	}

	
	// Getters & Setters
	public long getCdPedido() {
		return cdPedido;
	}

	public void setCdPedido(long cdPedido) {
		this.cdPedido = cdPedido;
	}

	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public float getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(float valorPedido) {
		this.valorPedido = valorPedido;
	}

	public float getValorTaxa() {
		return valorTaxa;
	}

	public void setValorTaxa(float valorTaxa) {
		this.valorTaxa = valorTaxa;
	}

}