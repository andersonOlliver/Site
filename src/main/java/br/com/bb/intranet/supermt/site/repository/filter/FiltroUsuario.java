package br.com.bb.intranet.supermt.site.repository.filter;

import java.io.Serializable;

public class FiltroUsuario extends Filtro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String chave;
	
	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}



	
}
