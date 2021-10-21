package biblioteca.modelo.pruebas;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import biblioteca.modelo.Usuario;


public class VerTodosLosUsuarios {

	public static void main(String[] args) {

		// == Cargar los datos de prueba
		
		// DatosPrueba.borrarDatosPrueba();
		// DatosPrueba.crearDatosPrueba();
		
		// == Conectar a la base de datos  		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("biblioteca_PU");
		EntityManager manager = factory.createEntityManager();
		
		// == Consultas de prueba
					
		String jpql = "select u from Usuario u";
		TypedQuery<Usuario> consulta = manager.createQuery( jpql, Usuario.class );
		
		List<Usuario> listaUsuarios = consulta.getResultList();
		
		for ( Usuario usuario : listaUsuarios) {
			System.out.println( usuario.getNombre() );			
		}
		
		System.out.println(".. done");
	}

}
