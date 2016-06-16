package br.com.bb.intranet.supermt.site.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.bb.intranet.supermt.site.model.Container;

public class Containers implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public Containers(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Container> todos(){
		TypedQuery<Container> query = manager.createQuery(
				"from Container", Container.class);
		return query.getResultList();
	}
	
	public Container porId(Long id){
		return manager.find(Container.class, id);
	}

	public void adicionar(Container container){
		this.manager.persist(container);
	}
	
	public void atualizar(Container container){
		this.manager.merge(container);
	}
	
}
