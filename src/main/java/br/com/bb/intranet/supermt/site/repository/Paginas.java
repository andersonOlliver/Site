package br.com.bb.intranet.supermt.site.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.bb.intranet.supermt.site.model.Pagina;

public class Paginas  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;

	@Inject
	public Paginas(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Pagina> todas(){
		TypedQuery<Pagina> query = manager.createQuery(
				"from Pagina", Pagina.class);
		return query.getResultList();
	}
	
	public Pagina porId(Long id){
		return manager.find(Pagina.class, id);
	}
	
	public void adicionar(Pagina pagina){
		this.manager.persist(pagina);
	}

	public void atualizar(Pagina pagina){
		this.manager.merge(pagina);
	}
	
	public void excluir(Pagina pagina){
		this.manager.remove(pagina);
	}
	
}
