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

import br.com.bb.intranet.supermt.site.model.Usuario;
import br.com.bb.intranet.supermt.site.repository.filter.FiltroUsuario;

public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public Usuarios(EntityManager manager) {
		this.manager = manager;
	}

	public List<Usuario> todos() {
		TypedQuery<Usuario> query = manager.createQuery("from Usuario", Usuario.class);
		return query.getResultList();
	}

	public Usuario porId(Long id) {
		return manager.find(Usuario.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> filtrados(FiltroUsuario filtro) {
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

	public int quantidadeFiltrados(FiltroUsuario filtro) {
		Criteria criteria = criarCriteria(filtro);

		criteria.setProjection(Projections.rowCount());

		return ((Number) criteria.uniqueResult()).intValue();
	}

	public void adicionar(Usuario usuario) {
		this.manager.persist(usuario);
	}

	public void atualizar(Usuario usuario) {
		this.manager.merge(usuario);
	}

	public Usuario porChave(String chave) {
		Criteria criteria = criarCriteria();
		criteria.add(Restrictions.eq("chave", chave));
		return (Usuario) criteria.uniqueResult();
	}

	private Criteria criarCriteria() {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Usuario.class);

		return criteria;
	}

	private Criteria criarCriteria(FiltroUsuario filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Usuario.class);

		if (StringUtils.isNotEmpty(filtro.getChave())) {
			criteria.add(Restrictions.ilike("chave", filtro.getChave()));
		}

		return criteria;
	}
	
	public void remover(Usuario usuario){
		this.manager.remove(usuario);
	}
}
