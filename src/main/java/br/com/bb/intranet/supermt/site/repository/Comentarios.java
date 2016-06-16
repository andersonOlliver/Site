package br.com.bb.intranet.supermt.site.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.bb.intranet.supermt.site.model.Comentario;

public class Comentarios implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public Comentarios(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Comentario> todos(){
		TypedQuery<Comentario> query = manager.createQuery(
				"from Comentario", Comentario.class);
		return query.getResultList();
	}
	
	public Comentario porId(Long id){
		return manager.find(Comentario.class, id);
	}
	
	public void adicionar(Comentario comentario){
		this.manager.persist(comentario);
	}
	
	public void atualizar(Comentario comentario){
		this.manager.merge(comentario);
	}

}
