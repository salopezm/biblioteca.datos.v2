package biblioteca.accesoDatos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import utils.accesoDatos.GenericJpaDAO;
import biblioteca.modelo.Reglamento;

@ApplicationScoped
public class DaoReglamento extends GenericJpaDAO<Reglamento, String>{

	public DaoReglamento() { }
	
	public DaoReglamento(EntityManager em) {
		super(em);
	}
	
}
