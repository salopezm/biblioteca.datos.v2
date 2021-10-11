package biblioteca.accesoDatos;

import jakarta.persistence.EntityManager;

import biblioteca.accesoDatos.utils.GenericJpaDAO;
import biblioteca.modelo.CategoriaLibro;

public class DaoCategoriaLibro extends GenericJpaDAO<CategoriaLibro, String>{

	// == constructores
	
	public DaoCategoriaLibro() { }
	
	public DaoCategoriaLibro(EntityManager em) {
		super(em);
	}
	
}
