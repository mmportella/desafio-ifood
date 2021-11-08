package br.com.fiap.ifood.model;

public class Restaurante {
	
	// Atributos
	private int cdRestaurante;
	private int cnpj;
	private String nomeRestaurante;
	private String endereco;
	private int telefone;
	private String tipoRestaurante;
	private String horarioFuncionamento;
	private  int avaliacao;
	private float pedidoMinimo;
	private boolean retirada;
	
	
	// Construtor
	public Restaurante() {
	}

	
	// Getters & Setters
	public int getCdRestaurante() {
		return cdRestaurante;
	}

	public void setCdRestaurante(int cdRestaurante) {
		this.cdRestaurante = cdRestaurante;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeRestaurante() {
		return nomeRestaurante;
	}

	public void setNomeRestaurante(String nomeRestaurante) {
		this.nomeRestaurante = nomeRestaurante;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getTipoRestaurante() {
		return tipoRestaurante;
	}

	public void setTipoRestaurante(String tipoRestaurante) {
		this.tipoRestaurante = tipoRestaurante;
	}

	public String getHorarioFuncionamento() {
		return horarioFuncionamento;
	}

	public void setHorarioFuncionamento(String horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	public float getPedidoMinimo() {
		return pedidoMinimo;
	}

	public void setPedidoMinimo(float pedidoMinimo) {
		this.pedidoMinimo = pedidoMinimo;
	}

	public boolean isRetirada() {
		return retirada;
	}

	public void setRetirada(boolean retirada) {
		this.retirada = retirada;
	}
	
}