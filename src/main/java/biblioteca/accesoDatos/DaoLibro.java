package biblioteca.accesoDatos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import utils.accesoDatos.GenericJpaDAO;
import biblioteca.modelo.Libro;

@ApplicationScoped 
public class DaoLibro extends GenericJpaDAO<Libro, String>{

	public DaoLibro() { }
	
	public DaoLibro(EntityManager em) {
		super(em);
	}
	
}
