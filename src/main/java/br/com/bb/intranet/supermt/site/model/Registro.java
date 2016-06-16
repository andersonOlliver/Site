package br.com.bb.intranet.supermt.site.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "registro")
public class Registro implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Conteudo conteudo;
    private Usuario usuario;
    
    @Id
    @GeneratedValue
	public Long getId() {
		return id;
	}
	
    public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "conteudo_id")
	public Conteudo getConteudo() {
		return conteudo;
	}
	
	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id")
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registro other = (Registro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
