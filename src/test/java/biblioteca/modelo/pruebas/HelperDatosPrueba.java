package biblioteca.modelo.pruebas;

import java.util.Date;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import biblioteca.modelo.CategoriaLibro;
import biblioteca.modelo.Copia;
import biblioteca.modelo.Libro;
import biblioteca.modelo.Reglamento;
import biblioteca.modelo.TipoUsuario;
import biblioteca.modelo.Usuario;

public class HelperDatosPrueba {

	public static void borrarDatosPrueba() {

		initDB();
		
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		manager.createQuery( "DELETE FROM Multa" ).executeUpdate();
		tx.commit();
		
		tx.begin();
		manager.createQuery( "DELETE FROM Prestamo" ).executeUpdate();
		tx.commit();
				
		tx.begin();
		manager.createQuery( "DELETE FROM Usuario" ).executeUpdate();
		tx.commit();
				
		tx.begin();
		manager.createQuery( "DELETE FROM Copia" ).executeUpdate();
		tx.commit();
		
		tx.begin();
		manager.createQuery( "DELETE FROM Libro" ).executeUpdate();
		tx.commit();
		
		tx.begin();
		manager.createQuery( "DELETE FROM Reglamento" ).executeUpdate();
		tx.commit();
		
		tx.begin();
		manager.createQuery( "DELETE FROM TipoUsuario" ).executeUpdate();
		tx.commit();

		
		tx.begin();
		manager.createQuery( "DELETE FROM CategoriaLibro" ).executeUpdate();		
		tx.commit();
		
	}

	public static void crearCategoriaLibro(String id, String nombre) {
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		CategoriaLibro categoriaLibro = new CategoriaLibro();
		categoriaLibro.setId(id);
		categoriaLibro.setNombre(nombre);
		
		manager.persist(categoriaLibro);
		
		tx.commit();		
		
	}
	
	public static void crearLibro(long isbn, String titulo, String autor, String editor, Date fechaPublicacion, String idCategoria) {
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		CategoriaLibro categoria = manager.find( CategoriaLibro.class, idCategoria );
		
		Libro libro = new Libro();
		libro.setIsbn(isbn);
		libro.setTitulo(titulo);
		libro.setAutor(autor);
		libro.setEditor(editor);
		libro.setFechaPublicacion(fechaPublicacion);
		libro.setCategoriaLibro(categoria);
		manager.persist(libro);
		
		categoria.getLibros().add(libro);
		manager.persist(categoria);
		
		tx.commit();		
		
	}
	
	public static void crearCopia( long isbnLibro, long codigoBarras, Date fechaAdquisicion, boolean disponible ) {
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		Libro libro = manager.find( Libro.class, isbnLibro );
		
		Copia copia = new Copia();
		copia.setCodigoBarras(codigoBarras);
		copia.setFechaAdquisicion(fechaAdquisicion);
		copia.setDisponible(disponible);
		copia.setLibro(libro);
		manager.persist(copia);
		
		libro.getCopias().add(copia);
		manager.persist(libro);
		
		tx.commit();		

	}
	
	public static void crearTipoUsuario( String id, String nombre ) {
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setId(id);
		tipoUsuario.setNombre(nombre);
		manager.persist(tipoUsuario);
		
		tx.commit();				
		
	}
	
	public static void crearUsuario( String codigo, String numDocumento, String nombre, String direccion, String idTipo ) {
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		TipoUsuario tipoUsuario = manager.find( TipoUsuario.class, idTipo );
		
		Usuario usuario = new Usuario();
		usuario.setCodigo(codigo);
		usuario.setNumDocumento(numDocumento);
		usuario.setNombre(nombre);
		usuario.setDireccion(direccion);
		usuario.setTipo(tipoUsuario);
		manager.persist(usuario);
		
		tipoUsuario.getUsuarios().add( usuario );
		manager.persist(tipoUsuario);
		
		tx.commit();
		
	}

	public static void crearReglamento( String idCategoria, String idTipoUsuario, int diasPrestamo, double MultaDiaria) {
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		CategoriaLibro categoriaLibro = manager.find(CategoriaLibro.class, idCategoria );
		TipoUsuario tipoUsuario = manager.find( TipoUsuario.class, idTipoUsuario );
		
		Reglamento reglamento = new Reglamento();
		reglamento.setCategoriaLibro(categoriaLibro);
		reglamento.setTipoUsuario(tipoUsuario);
		reglamento.setDiasPrestamo(diasPrestamo);
		reglamento.setMultaDiaria(MultaDiaria);
		manager.persist(reglamento);
		
		categoriaLibro.getReglamentos().add(reglamento);
		manager.persist(categoriaLibro);
		
		tipoUsuario.getReglamentos().add(reglamento);
		manager.persist(tipoUsuario);
		
		tx.commit();
		
		
	}

	
	// --

	static EntityManager manager;
	
	public static void initDB() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("biblioteca_PU");
		manager = factory.createEntityManager();
	}
	
	public static void crearDatosPrueba() {

		initDB();
		
		crearCategoriaLibro("general", "Colección General");
		crearCategoriaLibro("reserva", "Colección Reserva");
		
		crearLibro(1L, "La Biblia", 		"", 			"", new Date(), "general");
		crearLibro(2L, "Romeo y Julieta", 	"Shakespeare", 	"", new Date(), "general");
		crearLibro(3L, "El Quijote", 		"Cervantes", 	"", new Date(), "general");
		crearLibro(4L, "Algebra", 			"Baldor", 		"", new Date(), "reserva");
		crearLibro(5L, "Fisica", 			"Serway", 		"", new Date(), "reserva");
		
		crearCopia( 1L,  101L, new Date(), true);	// la biblia
		crearCopia( 1L,  102L, new Date(), true);
		crearCopia( 2L,  201L, new Date(), true);	// romeo y julieta
		crearCopia( 3L,  301L, new Date(), true);	// el quijote
		crearCopia( 4L,  401L, new Date(), true);	// algebra
		crearCopia( 4L,  402L, new Date(), true);
		crearCopia( 5L,  501L, new Date(), true);	// fisica

		crearTipoUsuario("profesor", 	"Profesores de la Universidad");
		crearTipoUsuario("estudiante", 	"Estudiantes de la Universidad");
		
		crearUsuario("100-01", "101", "paola", 	"", "profesor");
		crearUsuario("100-02", "102", "jaime", 	"", "profesor");
		crearUsuario("200-01", "201", "jorgue",	"", "estudiante");
		crearUsuario("200-02", "202", "juan", 	"", "estudiante");
		
		//				categoria, tipo-usr, dias prestamo, valor multa diaria
		crearReglamento("general", "profesor",	 10, 100.0);
		crearReglamento("reserva", "profesor", 	  5, 100.0);
		crearReglamento("general", "estudiante", 10, 150.0);
		crearReglamento("reserva", "estudiante",  5, 250.0);
		
	}	
	
}
