package br.com.bb.intranet.supermt.site.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "noticia")
public class Noticia extends Conteudo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String valor;
    private List<Comentario> comentarios;
    
    @NotNull
    @Size(max = 3000)
    @Column(name = "valor_noticia", length = 3000)
	public String getValor() {
		return valor;
	}
    
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.getId() == null) ? 0 : this.getId().hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Noticia other = (Noticia) obj;
		if (this.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!this.getId().equals(other.getId()))
			return false;
		return true;
	}

}
