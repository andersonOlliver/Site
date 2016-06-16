package br.com.bb.intranet.supermt.site.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.bb.intranet.supermt.site.model.Registro;

public class Registros implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public Registros(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Registro> todos(){
		TypedQuery<Registro> query = manager.createQuery(
				"from Cadastro", Registro.class);
		return query.getResultList();
	}
	
	public Registro porId(Long id){
		return manager.find(Registro.class, id);
	}
	
	public void adicionar(Registro cadastro){
		this.manager.persist(cadastro);
	}
	
	public void atualizar(Registro cadastro){
		this.manager.merge(cadastro);
	}

}
