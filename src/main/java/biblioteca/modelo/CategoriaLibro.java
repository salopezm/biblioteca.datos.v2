package biblioteca.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CategoriaLibro {

	@Id
	private String id;

	private String nombre;

	@OneToMany(mappedBy="categoriaLibro", cascade={CascadeType.ALL, CascadeType.REMOVE})
	private List<Reglamento> reglamentos;
	
	@OneToMany(mappedBy="categoriaLibro", cascade={CascadeType.ALL, CascadeType.REMOVE})
	private List<Libro> libros;

	
	public CategoriaLibro() {
	}

	public void setId(String value) {
		this.id = value;
	}

	public String getId() {
		return this.id;
	}

	public void setNombre(String value) {
		this.nombre = value;
	}

	public String getNombre() {
		return this.nombre;
	}

	public List<Reglamento> getReglamentos() {
		if (this.reglamentos == null) {
			this.reglamentos = new ArrayList<Reglamento>();
		}
		return this.reglamentos;
	}

	public void setReglamentos(List<Reglamento> reglamentos) {
		this.reglamentos = reglamentos;
	}
	
	public List<Libro> getLibros() {
		if (this.libros == null) {
			this.libros = new ArrayList<Libro>();
		}
		return libros;
	}
	
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
}
