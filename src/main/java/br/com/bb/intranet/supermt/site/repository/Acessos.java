package br.com.bb.intranet.supermt.site.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.bb.intranet.supermt.site.model.Acesso;

public class Acessos  implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public Acessos(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Acesso> todos(){
		TypedQuery<Acesso> query = manager.createQuery(
				"from Navegacao", Acesso.class);
		return query.getResultList();
	}
	
	public Acesso porId(Long id){
		return manager.find(Acesso.class, id);
	}
	
	public void adicionar(Acesso navegacao){
		this.manager.persist(navegacao);
	}
	
	public void atualizar(Acesso navegacao){
		this.manager.merge(navegacao);
	}

}
