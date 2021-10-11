package biblioteca.logica;

import jakarta.persistence.EntityManager;

import biblioteca.accesoDatos.utils.JpaUtils;

public class ServiciosCirculacion {

	static EntityManager manager;

	private static void initDB() {		
		if ( manager == null ) {
			manager = JpaUtils.getEntityManager("biblioteca_PU"); 
		}
	}
	
	// --
	
	public static void prestarCopia( String idUsuario, long codigoBarras ) 
		throws Exception {
	
		initDB();		
	
	}

	public static void devolverCopia( long codigoBarras ) 
		throws Exception {
	
		initDB();		

	}	
	
}
