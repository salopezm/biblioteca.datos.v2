package biblioteca.accesoDatos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import utils.accesoDatos.GenericJpaDAO;

import static utils.accesoDatos.FluentMap.Map;
import static utils.accesoDatos.FluentMap.entry;

import biblioteca.modelo.Usuario;

@ApplicationScoped
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
