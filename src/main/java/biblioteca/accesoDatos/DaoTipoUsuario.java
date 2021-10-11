package biblioteca.accesoDatos;

import jakarta.persistence.EntityManager;

import biblioteca.accesoDatos.utils.GenericJpaDAO;
import biblioteca.modelo.TipoUsuario;

public class DaoTipoUsuario extends GenericJpaDAO<TipoUsuario, String>{

	// == constructores
	
	public DaoTipoUsuario() { }
	
	public DaoTipoUsuario(EntityManager em) {
		super(em);
	}
	
}
