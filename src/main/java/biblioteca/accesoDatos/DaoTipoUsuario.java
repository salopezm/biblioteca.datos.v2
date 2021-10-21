package biblioteca.accesoDatos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import utils.accesoDatos.GenericJpaDAO;
import biblioteca.modelo.TipoUsuario;

@ApplicationScoped
public class DaoTipoUsuario extends GenericJpaDAO<TipoUsuario, String>{

	public DaoTipoUsuario() { }
	
	public DaoTipoUsuario(EntityManager em) {
		super(em);
	}
	
}
