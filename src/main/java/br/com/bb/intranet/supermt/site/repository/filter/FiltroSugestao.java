package br.com.bb.intranet.supermt.site.repository.filter;

import java.io.Serializable;

public class FiltroSugestao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String estado;
	
	private int primeiroRegistro;
	private int quantidadeRegistros;
	private String propriedadeOrdenacao;
	private boolean ascendente;
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public int getPrimeiroRegistro() {
		return primeiroRegistro;
	}
	
	public void setPrimeiroRegistro(int primeiroRegistro) {
		this.primeiroRegistro = primeiroRegistro;
	}
	
	public int getQuantidadeRegistros() {
		return quantidadeRegistros;
	}
	
	public void setQuantidadeRegistros(int quantidadeRegistros) {
		this.quantidadeRegistros = quantidadeRegistros;
	}
	
	public String getPropriedadeOrdenacao() {
		return propriedadeOrdenacao;
	}
	
	public void setPropriedadeOrdenacao(String propriedadeOrdenacao) {
		this.propriedadeOrdenacao = propriedadeOrdenacao;
	}
	
	public boolean isAscendente() {
		return ascendente;
	}
	
	public void setAscendente(boolean ascendente) {
		this.ascendente = ascendente;
	}

}
