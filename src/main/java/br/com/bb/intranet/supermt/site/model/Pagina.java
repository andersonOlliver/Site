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
@Table(name = "pagina")
public class Pagina implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nomePagina;
	private String enderecoPagina;
	private Menu menu;
	private Mercado mercado;
	private List<Container> containers = new ArrayList<>();
	private List<Acesso> navegacoes = new ArrayList<>();
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty
	@Size(max = 50)
	@Column(length = 50, nullable = false)
	public String getNomePagina() {
		return nomePagina;
	}
	
	public void setNomePagina(String nomePagina) {
		this.nomePagina = nomePagina;
	}
	
	
	@Size(max = 500)
	@Column(length = 500)
	public String getEnderecoPagina() {
		return enderecoPagina;
	}

	public void setEnderecoPagina(String enderecoPagina) {
		this.enderecoPagina = enderecoPagina;
	}

	@OneToMany(mappedBy = "pagina", cascade = CascadeType.ALL)
	public List<Container> getContainers() {
		return containers;
	}
	public void setContainers(List<Container> containers) {
		this.containers = containers;
	}

	@NotNull
	@ManyToOne(optional = false)
    @JoinColumn(name = "menu_id")
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	@NotNull
	@ManyToOne(optional = false)
    @JoinColumn(name = "mercado_id")
	public Mercado getMercado() {
		return mercado;
	}

	public void setMercado(Mercado mercado) {
		this.mercado = mercado;
	}

	@OneToMany(mappedBy = "pagina", cascade = CascadeType.ALL)
	public List<Acesso> getNavegacoes() {
		return navegacoes;
	}

	public void setNavegacoes(List<Acesso> navegacoes) {
		this.navegacoes = navegacoes;
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
		Pagina other = (Pagina) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
