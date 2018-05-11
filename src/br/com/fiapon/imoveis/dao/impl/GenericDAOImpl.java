package br.com.fiapon.imoveis.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiapon.imoveis.dao.GenericDAO;
import br.com.fiapon.imoveis.singleton.EntityManagerFactorySingleton;;

public class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

	protected EntityManager em;

	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		this.em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void cadastrar(T entidade) {
		em.persist(entidade);
	}

	public void atualizar(T entidade) {
		em.merge(entidade);
	}

	public T buscar(K chave) {
		return em.find(clazz, chave);
	}

	public void remover(K chave) throws Exception {
		T entidade = buscar(chave);
		if (entidade == null) {
			throw new Exception("Entidade não encontrada");
		}

		em.remove(entidade);
	}

	public List<T> listar() {
		return em.createQuery("from " + clazz.getName(), clazz).getResultList();
	}

	public void commit() throws Exception {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw new Exception("Erro no commit");
		}
	}
}