package biblioteca.logica.pruebas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;

import jakarta.inject.Inject;

import biblioteca.logica.ServiciosUsuarios;
import biblioteca.modelo.pruebas.DatosPrueba;


@EnableWeld
public class PruebaServicioUsuarios {

	@WeldSetup
    public WeldInitiator weld = WeldInitiator.performDefaultDiscovery();
	
	@Inject	ServiciosUsuarios serviciosUsuarios;
	@Inject	DatosPrueba datosPrueba;

	@BeforeEach
	public void inicializaBaseDatos() {
		datosPrueba.borrarDatosPrueba();
		datosPrueba.crearDatosPrueba();
	}
	
	@Test
	public void pruebaRegistrarUsuario() {
		try {
			serviciosUsuarios.registarUsuario("300-01", "301", "profesor", "mark", "calle 36");
		} catch (Exception e) {
			e.printStackTrace();
			fail( "Generó error cuando no debía" );
		}
	}
	
	@Test
	public void pruebaRegistrarUsuarioConElMismoCodigo() {
		// NOTA: El escenario de pruebas ya tiene un usuario con código "200-01"
		try {
			serviciosUsuarios.registarUsuario("200-01", "201", "profesor", "mark", "calle 36");
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
			serviciosUsuarios.registarUsuario("300-01", "201", "profesor", "mark", "calle 36");
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
			serviciosUsuarios.registarUsuario("300-01", "301", "otto", "mark", "calle 36");
			fail( "No generó error al crear un usuario con un tipo de no existente" );
		} catch (Exception e) {			
			// ok
			e.printStackTrace();
		}
	}

	@Test
	public void pruebaRegistrarUsuarioSinNombre() {
		try {
			serviciosUsuarios.registarUsuario("300-01", "301", "profesor", null, "calle 36");
			fail( "No generó error al crear un usuario sin nombre" );
		} catch (Exception e) {			
			// ok
			e.printStackTrace();
		}
	}

	@Test
	public void pruebaRegistrarUsuarioSinDireccion() {
		try {
			serviciosUsuarios.registarUsuario("300-01", "301", "profesor", "otto", null);
			fail( "No generó error al crear un usuario sin dirección" );
		} catch (Exception e) {			
			// ok
			e.printStackTrace();
		}
	}
}
