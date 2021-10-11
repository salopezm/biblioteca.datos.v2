package biblioteca.accesoDatos;

import jakarta.persistence.EntityManager;

import static biblioteca.accesoDatos.utils.FluentMap.Map;
import static biblioteca.accesoDatos.utils.FluentMap.entry;
import biblioteca.accesoDatos.utils.GenericJpaDAO;
import biblioteca.modelo.Usuario;

public class DaoUsuario extends GenericJpaDAO<Usuario, String>{

	// == constructores
	
	public DaoUsuario() { }
	
	public DaoUsuario(EntityManager em) {
		super(em);
	}
	
	// == consultas
	
	public Usuario buscarPorNumDocumento(String numDocumento) {
		return executeSingleResultNamedQuery("usuario.buscarPorNumDocumento", 
				Map( entry("numDocumento", numDocumento) ));
	}
	
}
