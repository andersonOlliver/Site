package br.com.bb.intranet.supermt.site.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "mercado")
public class Mercado implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private List<Pagina> paginas = new ArrayList<>();
    
    @Id
    @GeneratedValue
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotEmpty
	@Size(max = 20)
	@Column(length = 20, nullable = false)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@OneToMany(mappedBy = "mercado", cascade = CascadeType.ALL)
	public List<Pagina> getPaginas() {
		return paginas;
	}
	
	public void setPaginas(List<Pagina> paginas) {
		this.paginas = paginas;
	}
    
    

}
