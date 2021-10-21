package biblioteca.logica.pruebas;

import java.util.Date;

import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.jboss.weld.junit5.auto.WeldJunit5AutoExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import biblioteca.accesoDatos.DaoCopia;
import biblioteca.errores.NotImplementedException;

import biblioteca.logica.ServiciosCirculacion;
import biblioteca.modelo.Copia;
import biblioteca.modelo.pruebas.HelperDatosPrueba;

import jakarta.inject.Inject;

@ExtendWith(WeldJunit5AutoExtension.class)
public class PruebaPrestarEjemplar {
	
	// inyección de dependencias para las pruebas
	@WeldSetup
    public WeldInitiator weld = WeldInitiator.performDefaultDiscovery();

	@Inject ServiciosCirculacion serviciosCirculacion; 
	
	@Inject HelperDatosPrueba	helperDatosPrueba;
		
	@Inject DaoCopia daoCopia;
	
	@BeforeEach
	public void borrarDatos() {
		helperDatosPrueba.borrarDatosPrueba();
	}

	// prestar libro OK
	@Test
	public void pruebaPrestarEjemplar() {

		// arrange
		
		// precondiciones
		// estado antes de la prueba
		helperDatosPrueba.crearCategoriaLibro("general", "General");
		helperDatosPrueba.crearLibro(1L, "La Biblia", "", "", new Date(), "general");
		helperDatosPrueba.crearCopia(1L, 100, new Date(), true);
		helperDatosPrueba.crearTipoUsuario("profesor", "Profesor");
		helperDatosPrueba.crearUsuario("1", "93", "jaime", "", "profesor");
		helperDatosPrueba.crearReglamento("general", "profesor", 10, 1500.0);

		// ejecutamos la acción con datos de entrada
		try {
			
			serviciosCirculacion.prestarCopia("1", 100L);  // solo le paso el id del libro y del usuario
			// ok -- no hay errores
			
			// obtiene la copia que se acaba de prestar
			Copia copia = daoCopia.findById(100L);
			Assertions.assertNotNull(copia);
			
			Assertions.assertEquals(copia.isDisponible(), false);

		} catch (NotImplementedException e) {
			Assertions.fail("No se ha implementado");
			
		} catch (Exception e) {
			Assertions.fail("falla debido a " +  e.getMessage());
			e.printStackTrace();
		}

	}

}
