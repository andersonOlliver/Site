package br.com.bb.intranet.supermt.site.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.bb.intranet.supermt.site.model.Menu;

public class Menus implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public Menus(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Menu> todos(){
		TypedQuery<Menu> query = manager.createQuery(
				"from Menu", Menu.class);
		return query.getResultList();
	}
	
	public Menu porId(Long id){
		return manager.find(Menu.class, id);
	}
	
	
	public void adicionar(Menu menu){
		this.manager.persist(menu);
	}
	
	public void atualizar(Menu menu){
		this.manager.merge(menu);
	}
	
	public void excluir(Menu menu){
		this.manager.remove(menu);
	}

}
