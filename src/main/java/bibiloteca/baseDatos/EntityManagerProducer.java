package bibiloteca.baseDatos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;

/**
 * Productor (único punto) que crea el EntitManager usado en la Bibliteca 
 */
@Singleton
public class EntityManagerProducer {
	
	@PersistenceContext(unitName = "biblioteca_PU")
	EntityManager manager;
	
    @Produces @BdBiblioteca @Default 
    @Dependent
	public EntityManager createEntityManager() {
    	
    	if (manager != null)
    		return manager;
    	
    	return Persistence
    			.createEntityManagerFactory("biblioteca_PU")
    			.createEntityManager();
	}
	
    public void close(@Disposes @BdBiblioteca EntityManager entityManager) {
    	entityManager.close();
    }

}
