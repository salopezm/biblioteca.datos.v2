package biblioteca.logica.pruebas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import biblioteca.logica.ServiciosUsuarios;
import biblioteca.modelo.pruebas.DatosPrueba;

public class PruebaServicioUsuarios {

	@BeforeEach
	public void inicializaBaseDatos() {
		DatosPrueba.borrarDatosPrueba();
		DatosPrueba.crearDatosPrueba();
	}
	
	@Test
	public void pruebaRegistrarUsuario() {
		try {
			ServiciosUsuarios.registarUsuario("300-01", "301", "profesor", "mark", "calle 36");
		} catch (Exception e) {
			e.printStackTrace();
			fail( "Generó error cuando no debía" );
		}
	}
	
	@Test
	public void pruebaRegistrarUsuarioConElMismoCodigo() {
		// NOTA: El escenario de pruebas ya tiene un usuario con código "200-01"
		try {
			ServiciosUsuarios.registarUsuario("200-01", "201", "profesor", "mark", "calle 36");
			fail( "No generó error al crear un usuario con el mismo código" );
		} catch (Exception e) {
			// ok
			e.printStackTrace();
		}
	}

	@Test
	public void pruebaRegistrarUsuarioConElMismoNumDocumento() {
		// NOTA: El escenario de pruebas ya tiene un usuario con identificación "201"
		try {
			ServiciosUsuarios.registarUsuario("300-01", "201", "profesor", "mark", "calle 36");
			fail( "No generó error al crear un usuario con el mismo número de documento" );
		} catch (Exception e) {
			// ok
			e.printStackTrace();
		}
	}

	@Test
	public void pruebaRegistrarUsuarioConTipoNoExistente() {
		// NOTA: El escenario de pruebas no tiene un tipo de usuario "otto"
		try {
			ServiciosUsuarios.registarUsuario("300-01", "301", "otto", "mark", "calle 36");
			fail( "No generó error al crear un usuario con un tipo de no existente" );
		} catch (Exception e) {			
			// ok
			e.printStackTrace();
		}
	}

	@Test
	public void pruebaRegistrarUsuarioSinNombre() {
		try {
			ServiciosUsuarios.registarUsuario("300-01", "301", "profesor", null, "calle 36");
			fail( "No generó error al crear un usuario sin nombre" );
		} catch (Exception e) {			
			// ok
			e.printStackTrace();
		}
	}

	@Test
	public void pruebaRegistrarUsuarioSinDireccion() {
		try {
			ServiciosUsuarios.registarUsuario("300-01", "301", "profesor", "otto", null);
			fail( "No generó error al crear un usuario sin dirección" );
		} catch (Exception e) {			
			// ok
			e.printStackTrace();
		}
	}
}
