package biblioteca.modelo.pruebas;

import java.util.Date;

import static biblioteca.modelo.pruebas.HelperDatosPrueba.*;

public class DatosPrueba {

	public static void borrarDatosPrueba() {
		HelperDatosPrueba.borrarDatosPrueba();
	}
	
	public static void crearDatosPrueba() {

		initDB();
		
		// crearCategoriaLibro( id, nombre)
		crearCategoriaLibro("general", "Colección General");
		crearCategoriaLibro("reserva", "Colección Reserva");
		
		// crearLibro( isbn, titulo, autor, editor, fechaPublicacion, idCategoria)
		crearLibro(1L, "La Biblia", 		"", 			"", new Date(), "general");
		crearLibro(2L, "Romeo y Julieta", 	"Shakespeare", 	"", new Date(), "general");
		crearLibro(3L, "El Quijote", 		"Cervantes", 	"", new Date(), "general");
		crearLibro(4L, "Algebra", 			"Baldor", 		"", new Date(), "reserva");
		crearLibro(5L, "Fisica", 			"Serway", 		"", new Date(), "reserva");
		
		// crearCopia( isbnLibro, codigoBarras, fechaAdquisicion, disponible )
		crearCopia( 1L,  101L, new Date(), true);	// la biblia
		crearCopia( 1L,  102L, new Date(), true);
		crearCopia( 2L,  201L, new Date(), true);	// romeo y julieta
		crearCopia( 3L,  301L, new Date(), true);	// el quijote
		crearCopia( 4L,  401L, new Date(), true);	// algebra
		crearCopia( 4L,  402L, new Date(), true);
		crearCopia( 5L,  501L, new Date(), true);	// fisica

		// crearTipoUsuario( id, nombre );
		crearTipoUsuario("profesor", 	"Profesores de la Universidad");
		crearTipoUsuario("estudiante", 	"Estudiantes de la Universidad");
		
		// crearUsuario( codigo, numDocumento, nombre, direccion, idTipo )
		crearUsuario("100-01", "101", "paola", 	"", "profesor");
		crearUsuario("100-02", "102", "jaime", 	"", "profesor");
		crearUsuario("200-01", "201", "jorgue",	"", "estudiante");
		crearUsuario("200-02", "202", "juan", 	"", "estudiante");
		
		// crearReglamento( categoria, tipo-usr, dias prestamo, valor multa diaria )
		crearReglamento("general", "profesor",	 10, 100.0);
		crearReglamento("reserva", "profesor", 	  5, 100.0);
		crearReglamento("general", "estudiante", 10, 150.0);
		crearReglamento("reserva", "estudiante",  5, 250.0);
		
	}	
	
}
