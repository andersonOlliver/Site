package br.com.bb.intranet.supermt.site.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.bb.intranet.supermt.site.model.Conteudo;
import br.com.bb.intranet.supermt.site.model.Noticia;
import br.com.bb.intranet.supermt.site.repository.filter.FiltroConteudo;
import br.com.bb.intranet.supermt.site.repository.filter.FiltroNoticia;

public class Noticias implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public Noticias(EntityManager manager) {
		this.manager = manager;
	}
	
	/*
	 * CONSULTAS
	 */
	
	public List<Noticia> todos(){
		TypedQuery<Noticia> query = manager.createQuery(
				"from Noticia", Noticia.class);
		return query.getResultList();
	}
	
	public Noticia porId(Long id){
		return manager.find(Noticia.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Conteudo> filtrados(FiltroNoticia filtro) {
		Criteria criteria = criarCriteria(filtro);

		criteria.setFirstResult(filtro.getPrimeiroRegistro());
		criteria.setMaxResults(filtro.getQuantidadeRegistros());

		if (filtro.isAscendente() && filtro.getPropriedadeOrdenacao() != null) {
			criteria.addOrder(Order.asc(filtro.getPropriedadeOrdenacao()));
		} else if (filtro.getPropriedadeOrdenacao() != null) {
			criteria.addOrder(Order.desc(filtro.getPropriedadeOrdenacao()));
		}

		return criteria.list();
	}
	
	public int quantidadeFiltrados(FiltroNoticia filtro) {
		Criteria criteria = criarCriteria(filtro);

		criteria.setProjection(Projections.rowCount());

		return ((Number) criteria.uniqueResult()).intValue();
	}
	/*
	 * INSERÇÕES
	 */
	
	public void adicionar(Noticia noticia){
		this.manager.persist(noticia);
	}
	
	public void atualizar(Noticia noticia){
		this.manager.merge(noticia);
	}

	/*
	 * CONFIGURAÇÃO DE SESSÃO
	 */
	private Criteria criarCriteria() {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Conteudo.class);

		return criteria;
	}
	
	private Criteria criarCriteria(FiltroNoticia filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Noticia.class);

		if (StringUtils.isNotEmpty(filtro.getTitulo())) {
			criteria.add(Restrictions.ilike("titulo", filtro.getTitulo()));
		}

		return criteria;
	}
}
