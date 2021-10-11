package biblioteca.accesoDatos;

import jakarta.persistence.EntityManager;

import biblioteca.accesoDatos.utils.GenericJpaDAO;
import biblioteca.modelo.Prestamo;

public class DaoPrestamo extends GenericJpaDAO<Prestamo, String>{

	// == constructores
	
	public DaoPrestamo() { }
	
	public DaoPrestamo(EntityManager em) {
		super(em);
	}
	
}
