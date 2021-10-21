package biblioteca.modelo.pruebas;

import java.util.Date;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import biblioteca.modelo.CategoriaLibro;
import biblioteca.modelo.Copia;
import biblioteca.modelo.Libro;
import biblioteca.modelo.Reglamento;
import biblioteca.modelo.TipoUsuario;
import biblioteca.modelo.Usuario;

@ApplicationScoped
public class HelperDatosPrueba {

	@Inject EntityManager manager;
	
	// ---
	
	public void borrarDatosPrueba() {

		System.out.println("manager " + manager);
		
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

	public void crearCategoriaLibro(String id, String nombre) {
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		CategoriaLibro categoriaLibro = new CategoriaLibro();
		categoriaLibro.setId(id);
		categoriaLibro.setNombre(nombre);
		
		manager.persist(categoriaLibro);
		
		tx.commit();		
		
	}
	
	public void crearLibro(long isbn, String titulo, String autor, String editor, Date fechaPublicacion, String idCategoria) {
		
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
	
	public void crearCopia( long isbnLibro, long codigoBarras, Date fechaAdquisicion, boolean disponible ) {
		
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
	
	public void crearTipoUsuario( String id, String nombre ) {
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setId(id);
		tipoUsuario.setNombre(nombre);
		manager.persist(tipoUsuario);
		
		tx.commit();				
		
	}
	
	public void crearUsuario( String codigo, String numDocumento, String nombre, String direccion, String idTipo ) {
		
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

	public void crearReglamento( String idCategoria, String idTipoUsuario, int diasPrestamo, double MultaDiaria) {
		
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

}
