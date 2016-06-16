package br.com.bb.intranet.supermt.site.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "container")
public class Container implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private Pagina pagina;
    private List<Conteudo> conteudos = new ArrayList<>();
	
    @Id
    @GeneratedValue
    public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotEmpty
	@Size(max=45)
	@Column(length = 45, nullable = false)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotNull
	@ManyToOne(optional = false)
    @JoinColumn(name = "pagina_id")
	public Pagina getPagina() {
		return pagina;
	}
	
	public void setPagina(Pagina pagina) {
		this.pagina = pagina;
	}
	
	@OneToMany(mappedBy = "container", cascade = CascadeType.ALL)
	public List<Conteudo> getConteudos() {
		return conteudos;
	}
	
	public void setConteudos(List<Conteudo> conteudos) {
		this.conteudos = conteudos;
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
		Container other = (Container) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
    
    
    
}
