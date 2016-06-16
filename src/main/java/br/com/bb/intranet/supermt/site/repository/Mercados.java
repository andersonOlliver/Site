package br.com.bb.intranet.supermt.site.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.bb.intranet.supermt.site.model.Mercado;

public class Mercados implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public Mercados(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Mercado> todos(){
		TypedQuery<Mercado> query = manager.createQuery(
				"from Mercado", Mercado.class);
		return query.getResultList();
	}
	
	public Mercado porId(Long id){
		return manager.find(Mercado.class, id);
	}
	
	
	public void adicionar(Mercado mercado){
		this.manager.persist(mercado);
	}
	
	public void atualizar(Mercado mercado){
		this.manager.merge(mercado);
	}

}
