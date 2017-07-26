package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import util.JPAUtil;

public class DAO<T, K extends Number> {

	protected static final EntityManager em = JPAUtil.getEntityManager();
	private Class<T> entity;

	@SuppressWarnings("unchecked")
	public DAO() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entity = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}

	public void cadastrar(T obj) {
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
	}

	public T alterar(T obj) {
		em.getTransaction().begin();
		obj = em.merge(obj);
		em.getTransaction().commit();
		return obj;
	}

	public void remover(K key) {
		em.getTransaction().begin();
		T target = em.find(entity, key);
		em.remove(target);
		em.getTransaction().commit();
	}

	public List<T> buscarTodos() {
		return em.createQuery("select e from " + entity.getSimpleName() + " e", entity).getResultList();
	}

}
