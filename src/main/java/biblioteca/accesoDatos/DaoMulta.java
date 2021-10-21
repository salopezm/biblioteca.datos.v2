package biblioteca.accesoDatos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import utils.accesoDatos.GenericJpaDAO;
import biblioteca.modelo.Multa;

@ApplicationScoped
public class DaoMulta extends GenericJpaDAO<Multa, String>{

	public DaoMulta() { }
	
	public DaoMulta(EntityManager em) {
		super(em);
	}
	
}
