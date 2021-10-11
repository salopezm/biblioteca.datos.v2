package biblioteca.accesoDatos;

import jakarta.persistence.EntityManager;

import biblioteca.accesoDatos.utils.GenericJpaDAO;
import biblioteca.modelo.Reglamento;

public class DaoReglamento extends GenericJpaDAO<Reglamento, String>{

	// == constructores
	
	public DaoReglamento() { }
	
	public DaoReglamento(EntityManager em) {
		super(em);
	}
	
}
