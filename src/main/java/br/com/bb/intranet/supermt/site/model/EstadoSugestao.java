package br.com.bb.intranet.supermt.site.model;

public enum EstadoSugestao {

	ATENDIDA("atendida"), 
	RECUSADA("recusada"), 
	EM_ANALISE("em análise");

	private String estado;

	EstadoSugestao(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

}
