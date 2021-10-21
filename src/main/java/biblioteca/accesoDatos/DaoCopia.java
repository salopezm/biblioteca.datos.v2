package biblioteca.accesoDatos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import utils.accesoDatos.GenericJpaDAO;
import biblioteca.modelo.Copia;

@ApplicationScoped
public class DaoCopia extends GenericJpaDAO<Copia, Long>{

	public DaoCopia() { }
	
	public DaoCopia(EntityManager em) {
		super(em);
	}
	
}
