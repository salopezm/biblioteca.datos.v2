package biblioteca.accesoDatos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import utils.accesoDatos.GenericJpaDAO;
import biblioteca.modelo.CategoriaLibro;

@ApplicationScoped
public class DaoCategoriaLibro extends GenericJpaDAO<CategoriaLibro, String>{

	public DaoCategoriaLibro() { }
	
	public DaoCategoriaLibro(EntityManager em) {
		super(em);
	}
	
}
