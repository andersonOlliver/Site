package br.com.bb.intranet.supermt.site.model;

public enum TipoUsuario {

	ADMINISTRADOR("administrador"), 
	COMUM("comum");

	private String descricao;

	TipoUsuario(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
