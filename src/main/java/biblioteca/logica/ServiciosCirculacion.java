package biblioteca.logica;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import biblioteca.accesoDatos.DaoCopia;
import biblioteca.accesoDatos.DaoUsuario;
import biblioteca.errores.NotImplementedException;
import biblioteca.modelo.Copia;
import biblioteca.modelo.Usuario;

@ApplicationScoped
public class ServiciosCirculacion {

	@Inject	DaoUsuario 		daoUsuario;
	@Inject DaoCopia		daoCopia;

		
	public ServiciosCirculacion() { }
	
	// == casos de uso
	
	// CU 6: Prestar Ejemplar
	public void prestarCopia( String idUsuario, long codigoBarras ) 
		throws Exception {
	
		// 3. Valida el usuario
		Usuario u = daoUsuario.findById(idUsuario);
		if (u == null ) {
			throw new Exception("No existe un usuario con ese código");
		}
				
		// 5. Verifica que el usuario no tenga multas
		
		// 6. Verifica que el usuario no tenga más de cinco libros prestados
		
		// 7. Verifica que exista una copia con ese código de barras
		Copia c = daoCopia.findById(codigoBarras);
		if (c == null) {
			throw new Exception("No existe un usuario con ese código");
		}
		
		// ::
		// cambia el estado de disponible de la copia
		c.setDisponible(false);
		
		daoCopia.beginTransaction();
		daoCopia.update(c);
		daoCopia.commit();
	
	}

	public static void devolverCopia( long codigoBarras ) 
		throws Exception {

		throw new NotImplementedException();

	}	
	
}
