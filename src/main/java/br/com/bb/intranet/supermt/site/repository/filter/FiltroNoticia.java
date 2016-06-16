package br.com.bb.intranet.supermt.site.repository.filter;

import java.io.Serializable;

public class FiltroNoticia extends Filtro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String titulo;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	

}
