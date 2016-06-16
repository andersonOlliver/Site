package br.com.bb.intranet.supermt.site.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.bb.intranet.supermt.site.model.Tag;

public class Tags  implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public Tags(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Tag> todos(){
		TypedQuery<Tag> query = manager.createQuery(
				"from Tag", Tag.class);
		return query.getResultList();
	}
	
	public Tag porId(Long id){
		return manager.find(Tag.class, id);
	}
	
	public Tag porValor(Tag tag){
		Criteria criteria = criarCriteria();
		
		criteria.add(Restrictions.ilike("valor", tag.getValor()));
		
		return (Tag) criteria.uniqueResult();
	}
	
	
	public void adicionar(Tag tag){
		this.manager.persist(tag);
	}
	
	public Tag atualizar(Tag tag){
		return this.manager.merge(tag);
	}
	
	public List<Tag> atualizar(List<Tag> tags){
		List<Tag> dadosSalvos = new ArrayList<Tag>();
		for (Tag aux : tags) {
			dadosSalvos.add(this.atualizar(aux));
		}
		return dadosSalvos;
	}
	
	
	
	private Criteria criarCriteria() {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Tag.class);

		return criteria;
	}
}
