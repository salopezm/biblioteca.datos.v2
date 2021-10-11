package biblioteca.accesoDatos;

import jakarta.persistence.EntityManager;

import biblioteca.accesoDatos.utils.GenericJpaDAO;
import biblioteca.modelo.Libro;

public class DaoLibro extends GenericJpaDAO<Libro, String>{

	// == constructores
	
	public DaoLibro() { }
	
	public DaoLibro(EntityManager em) {
		super(em);
	}
	
}
