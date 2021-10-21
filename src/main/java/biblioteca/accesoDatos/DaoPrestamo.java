package biblioteca.accesoDatos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import utils.accesoDatos.GenericJpaDAO;
import biblioteca.modelo.Prestamo;

@ApplicationScoped
public class DaoPrestamo extends GenericJpaDAO<Prestamo, String>{

	public DaoPrestamo() { }
	
	public DaoPrestamo(EntityManager em) {
		super(em);
	}
	
}
