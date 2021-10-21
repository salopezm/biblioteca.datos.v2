package biblioteca.modelo.pruebas;

import java.util.Date;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DatosPrueba {

	@Inject HelperDatosPrueba helper;
	
	public DatosPrueba() { }
		
	public void borrarDatosPrueba() {
		helper.borrarDatosPrueba();
	}	
	
	public void crearDatosPrueba() {

		// crearCategoriaLibro( id, nombre)
		helper.crearCategoriaLibro("general", "Colección General");
		helper.crearCategoriaLibro("reserva", "Colección Reserva");
		
		// crearLibro( isbn, titulo, autor, editor, fechaPublicacion, idCategoria)
		helper.crearLibro(1L, "La Biblia", 		"", 			"", new Date(), "general");
		helper.crearLibro(2L, "Romeo y Julieta", 	"Shakespeare", 	"", new Date(), "general");
		helper.crearLibro(3L, "El Quijote", 		"Cervantes", 	"", new Date(), "general");
		helper.crearLibro(4L, "Algebra", 			"Baldor", 		"", new Date(), "reserva");
		helper.crearLibro(5L, "Fisica", 			"Serway", 		"", new Date(), "reserva");
		
		// crearCopia( isbnLibro, codigoBarras, fechaAdquisicion, disponible )
		helper.crearCopia( 1L,  101L, new Date(), true);	// la biblia
		helper.crearCopia( 1L,  102L, new Date(), true);
		helper.crearCopia( 2L,  201L, new Date(), true);	// romeo y julieta
		helper.crearCopia( 3L,  301L, new Date(), true);	// el quijote
		helper.crearCopia( 4L,  401L, new Date(), true);	// algebra
		helper.crearCopia( 4L,  402L, new Date(), true);
		helper.crearCopia( 5L,  501L, new Date(), true);	// fisica

		// crearTipoUsuario( id, nombre );
		helper.crearTipoUsuario("profesor", 	"Profesores de la Universidad");
		helper.crearTipoUsuario("estudiante", 	"Estudiantes de la Universidad");
		
		// crearUsuario( codigo, numDocumento, nombre, direccion, idTipo )
		helper.crearUsuario("100-01", "101", "paola", 	"", "profesor");
		helper.crearUsuario("100-02", "102", "jaime", 	"", "profesor");
		helper.crearUsuario("200-01", "201", "jorgue",	"", "estudiante");
		helper.crearUsuario("200-02", "202", "juan", 	"", "estudiante");
		
		// crearReglamento( categoria, tipo-usr, dias prestamo, valor multa diaria )
		helper.crearReglamento("general", "profesor",	 10, 100.0);
		helper.crearReglamento("reserva", "profesor", 	  5, 100.0);
		helper.crearReglamento("general", "estudiante", 10, 150.0);
		helper.crearReglamento("reserva", "estudiante",  5, 250.0);
		
	}
	
}
