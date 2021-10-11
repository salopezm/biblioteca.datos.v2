package biblioteca.accesoDatos;

import jakarta.persistence.EntityManager;

import biblioteca.accesoDatos.utils.GenericJpaDAO;
import biblioteca.modelo.Multa;

public class DaoMulta extends GenericJpaDAO<Multa, String>{

	// == constructores
	
	public DaoMulta() { }
	
	public DaoMulta(EntityManager em) {
		super(em);
	}
	
}
