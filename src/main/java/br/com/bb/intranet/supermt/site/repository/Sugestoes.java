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

import br.com.bb.intranet.supermt.site.model.Sugestao;
import br.com.bb.intranet.supermt.site.model.Usuario;
import br.com.bb.intranet.supermt.site.repository.filter.FiltroSugestao;

public class Sugestoes implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public Sugestoes(EntityManager manager) {
		this.manager = manager;
	}

	public List<Sugestao> todas() {
		TypedQuery<Sugestao> query = manager.createQuery("from Sugestao", Sugestao.class);
		return query.getResultList();
	}

	public Sugestao porId(Long id) {
		return manager.find(Sugestao.class, id);
	}

	public void adicionar(Sugestao sugestao) {
		this.manager.persist(sugestao);
	}
	
	@SuppressWarnings("unchecked")
	public List<Sugestao> filtrados(FiltroSugestao filtro){
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
	
	public int quantidadeFiltrados(FiltroSugestao filtro) {
		Criteria criteria = criarCriteria(filtro);

		criteria.setProjection(Projections.rowCount());

		return ((Number) criteria.uniqueResult()).intValue();
	}

	private Criteria criarCriteria() {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Usuario.class);

		return criteria;
	}

	private Criteria criarCriteria(FiltroSugestao filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Sugestao.class);

		if (StringUtils.isNotEmpty(filtro.getEstado())) {
			criteria.add(Restrictions.ilike("estado", filtro.getEstado()));
		}

		return criteria;
	}
}
