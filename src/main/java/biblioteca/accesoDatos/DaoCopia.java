package biblioteca.accesoDatos;

import jakarta.persistence.EntityManager;

import biblioteca.accesoDatos.utils.GenericJpaDAO;
import biblioteca.modelo.Copia;

public class DaoCopia extends GenericJpaDAO<Copia, String>{

	// == constructores
	
	public DaoCopia() { }
	
	public DaoCopia(EntityManager em) {
		super(em);
	}
	
}
