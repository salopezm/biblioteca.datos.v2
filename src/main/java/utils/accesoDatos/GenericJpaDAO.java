package utils.accesoDatos;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

/**
 * Implementación de GenericDAO basada en el JPA Criteria API.
 *
 * @param <T>	Clase Entidad 
 * @param <ID>	Clase del identificador de la entidad
 */
public class GenericJpaDAO<T, ID extends Serializable> implements
		GenericDAO<T, ID> {

	@Inject private EntityManager em;
	
	private Class<T> persistentClass;

	private String persistentClassName = null;
	
	
	// == constructores
	
	@SuppressWarnings("unchecked")
	public GenericJpaDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public GenericJpaDAO(EntityManager em) {
		this();
		this.em = em;
	}

	// == métodos para determinar la clase Entidad del DAO
	
	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public String getPersistentClassName() {
		if (persistentClassName == null) { 
			persistentClassName = getPersistentClass().getName().substring(
					getPersistentClass().getPackage().getName().length()+1);
			
		}
		return persistentClassName;
	}
	

	// == Consultas básicas

	public T findById(ID id) {
		return findById( id, false );
	}
	
	public T findById(ID id, boolean lock) {
		T entity;
		if (lock) {
			entity = (T) em.find(getPersistentClass(), id);
			em.lock(entity, LockModeType.WRITE);
		} else {
			entity = em.find(getPersistentClass(), id);
		}

		return entity;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {	
		Query query = em.createQuery("select x from " 
				+ getPersistentClassName()
				+ " x ");
		return query.getResultList();
	}

	
	// == operaciones CRUD
	
	public T create(T entity) {
		em.persist(entity);
		return entity;
	}
	
    public T update(T entity) {
        return em.merge(entity);
    }	

	public void delete(T entity) {
		em.remove(entity);
	}

	public void deleteAll() {
		List<T> all = findAll();
		beginTransaction();
		for( T element : all ) {
			delete( element );			
		}
		commit();
	}

	// == Transacciones
	
	public void beginTransaction() {
		// inicia una transacción
		em.getTransaction().begin();
	}
	
	public void commit() {
		// hace commit de la transacción
		em.getTransaction().commit();
	}

	public void rollback() {
		try {
			// hace rollback  de la transacción
			em.getTransaction().rollback();
		} catch (Exception e) {
			// no haga nada ??
		}
	}	
	
	// == otras funciones
	
	public void flush() {
		em.flush();
	}

	public void clear() {
		em.clear();
	}

	
	// == soporte para ejecutar otras consultas
	
	@SuppressWarnings("unchecked")
	protected T executeSingleResultNamedQuery(String namedQuery) {
		Query consulta = em.createNamedQuery(namedQuery);
		T resultado = (T) consulta.getSingleResult();
		return resultado;	
	}

	@SuppressWarnings("unchecked")
	protected T executeSingleResultNamedQuery(String namedQuery, Object... params) {
		Query consulta = em.createNamedQuery(namedQuery);
		int paramNumber = 0;
		for(Object param: params) {
			if (param instanceof Map) {
				Map<String, Object> map = (Map<String, Object>) param;
				for(String paramName: map.keySet()) {
					consulta.setParameter(paramName, map.get(paramName));
				}				
			} else {
				consulta.setParameter(paramNumber++, param);
			}
		}
		try {
			T resultado = (T) consulta.getSingleResult();
			return resultado;	
		} catch (NoResultException e) {
			return null;
		}
	}	
	
	@SuppressWarnings("unchecked")
	protected List<T> executeListResultNamedQuery(String namedQuery) {
		Query consulta = em.createNamedQuery(namedQuery);
		List<T> resultado = consulta.getResultList();
		return resultado;	
	}

	@SuppressWarnings("unchecked")
	protected List<T> executeListResultNamedQuery(String namedQuery, Object... params) {
		Query consulta = em.createNamedQuery(namedQuery);
		int paramNumber = 0;
		for(Object param: params) {
			if (param instanceof Map) {
				Map<String, Object> map = (Map<String, Object>) param;
				for(String paramName: map.keySet()) {
					consulta.setParameter(paramName, map.get(paramName));
				}				
			} else {
				consulta.setParameter(paramNumber++, param);
			}
		}
		try {
			List<T> resultado = consulta.getResultList();
			return resultado;	
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	protected T executeSingleResultQuery(String query) {
		Query consulta = em.createQuery(query);
		T resultado = (T) consulta.getSingleResult();
		return resultado;	
	}

	@SuppressWarnings("unchecked")
	protected T executeSingleResultQuery(String query, Object... params) {
		Query consulta = em.createQuery(query);
		int paramNumber = 0;
		for(Object param: params) {
			if (param instanceof Map) {
				Map<String, Object> map = (Map<String, Object>) param;
				for(String paramName: map.keySet()) {
					consulta.setParameter(paramName, map.get(paramName));
				}				
			} else {
				consulta.setParameter(paramNumber++, param);
			}
		}
		try {
			T resultado = (T) consulta.getSingleResult();
			return resultado;	
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> executeListResultQuery(String query) {
		Query consulta = em.createQuery(query);
		List<T> resultado = consulta.getResultList();
		return resultado;	
	}

	@SuppressWarnings("unchecked")
	protected List<T> executeListResultQuery(String query, Object... params) {
		Query consulta = em.createQuery(query);
		int paramNumber = 0;
		for(Object param: params) {
			if (param instanceof Map) {
				Map<String, Object> map = (Map<String, Object>) param;
				for(String paramName: map.keySet()) {
					consulta.setParameter(paramName, map.get(paramName));
				}				
			} else {
				consulta.setParameter(paramNumber++, param);
			}
		}
		try {
			List<T> resultado = consulta.getResultList();
			return resultado;	
		} catch (NoResultException e) {
			return null;
		}
	}

}
