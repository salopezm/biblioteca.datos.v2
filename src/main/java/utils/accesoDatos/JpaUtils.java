package utils.accesoDatos;

import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class JpaUtils {
		
	public static Object executeSingleResultNamedQuery(EntityManager em, String namedQuery) {
		Query consulta = em.createNamedQuery(namedQuery);
		Object resultado = consulta.getSingleResult();
		return resultado;	
	}

	public static Object executeSingleResultNamedQuery(EntityManager em, String namedQuery, Object... params) {
		Query consulta = em.createNamedQuery(namedQuery);
		int paramNumber = 0;
		for(Object param: params) {
			consulta.setParameter(paramNumber++, param);
		}
		Object resultado = consulta.getSingleResult();
		return resultado;	
	}

	public static Object executeSingleResultNamedQuery(EntityManager em, String namedQuery, Map<String, Object> params) {
		Query consulta = em.createNamedQuery(namedQuery);
		for(String paramName: params.keySet()) {
			consulta.setParameter(paramName, params.get(paramName));
		}
		Object resultado = consulta.getSingleResult();
		return resultado;	
	}
	
	
	@SuppressWarnings( "rawtypes" )
	public static List executeListResultNamedQuery(EntityManager em, String namedQuery) {
		Query consulta = em.createNamedQuery(namedQuery);
		List resultado = consulta.getResultList();
		return resultado;	
	}

	@SuppressWarnings( "rawtypes" )
	public static List executeListResultNamedQuery(EntityManager em, String namedQuery, Object... params) {
		Query consulta = em.createNamedQuery(namedQuery);
		int paramNumber = 0;
		for(Object param: params) {
			consulta.setParameter(paramNumber++, param);
		}
		List resultado = consulta.getResultList();
		return resultado;	
	}

	@SuppressWarnings( "rawtypes" )
	public static List executeListResultNamedQuery(EntityManager em, String namedQuery, Map<String, Object> params) {
		Query consulta = em.createNamedQuery(namedQuery);
		for(String paramName: params.keySet()) {
			consulta.setParameter(paramName, params.get(paramName));
		}
		List resultado = consulta.getResultList();
		return resultado;	
	}

	
	public static Object executeSingleResultQuery(EntityManager em, String query) {
		Query consulta = em.createQuery(query);
		Object resultado = consulta.getSingleResult();
		return resultado;	
	}

	public static Object executeSingleResultQuery(EntityManager em, String query, Object... params) {
		Query consulta = em.createQuery(query);
		int paramNumber = 0;
		for(Object param: params) {
			consulta.setParameter(paramNumber++, param);
		}
		Object resultado = consulta.getSingleResult();
		return resultado;	
	}

	public static Object executeSingleResultQuery(EntityManager em, String query, Map<String, Object> params) {
		Query consulta = em.createNamedQuery(query);
		for(String paramName: params.keySet()) {
			consulta.setParameter(paramName, params.get(paramName));
		}
		Object resultado = consulta.getSingleResult();
		return resultado;	
	}	
	
	@SuppressWarnings( "rawtypes" )
	public static List executeListResultQuery(EntityManager em, String query) {
		Query consulta = em.createQuery(query);
		List resultado = consulta.getResultList();
		return resultado;	
	}

	@SuppressWarnings( "rawtypes" )
	public static List executeListResultQuery(EntityManager em, String query, Object... params) {
		Query consulta = em.createQuery(query);
		int paramNumber = 0;
		for(Object param: params) {
			consulta.setParameter(paramNumber++, param);
		}
		List resultado = consulta.getResultList();
		return resultado;	
	}
	
	@SuppressWarnings( "rawtypes" )
	public static List executeListResultQuery(EntityManager em, String query, Map<String, Object> params) {
		Query consulta = em.createNamedQuery(query);
		for(String paramName: params.keySet()) {
			consulta.setParameter(paramName, params.get(paramName));
		}
		List resultado = consulta.getResultList();
		return resultado;	
	}
}
