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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String link;
    private String titulo;
    private Menu menuPai;
    private List<Pagina> paginas = new ArrayList<>();
    private List<Menu> subMenus = new ArrayList<>();
    
    @Id
    @GeneratedValue
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Size(max = 800)
	@Column(length = 800)
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	@NotEmpty
	@Size(max = 50)
	@Column(length = 50, nullable = false)
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@ManyToOne
    @JoinColumn(name = "menu_pai_id")
	public Menu getMenuPai() {
		return menuPai;
	}
	
	public void setMenuPai(Menu menuPai) {
		this.menuPai = menuPai;
	}
	
	@OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
	public List<Pagina> getPaginas() {
		return paginas;
	}
	
	public void setPaginas(List<Pagina> paginas) {
		this.paginas = paginas;
	}
	
	@OneToMany(mappedBy = "menuPai", cascade = CascadeType.ALL)
	public List<Menu> getSubMenus() {
		return subMenus;
	}
	
	public void setSubMenus(List<Menu> subMenus) {
		this.subMenus = subMenus;
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
		Menu other = (Menu) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
    

}
