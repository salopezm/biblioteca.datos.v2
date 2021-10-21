package biblioteca.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Libro {

	@Id
	private long isbn;

	private String titulo;

	private String autor;

	private String editor;

	@Temporal(TemporalType.DATE)
	private Date fechaPublicacion;

	@ManyToOne
	@JoinColumn(name="id_categoria_libro")
	private CategoriaLibro categoriaLibro;

	@OneToMany(mappedBy="libro",  cascade={CascadeType.ALL, CascadeType.REMOVE})
	private List<Copia> copias;

	
	public Libro() {
	}
	
	public void setIsbn(long value) {
		this.isbn = value;
	}

	public long getIsbn() {
		return this.isbn;
	}

	public void setTitulo(String value) {
		this.titulo = value;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setAutor(String value) {
		this.autor = value;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setEditor(String value) {
		this.editor = value;
	}

	public String getEditor() {
		return this.editor;
	}

	public void setFechaPublicacion(Date value) {
		this.fechaPublicacion = value;
	}

	public CategoriaLibro getCategoriaLibro() {
		return categoriaLibro;
	}

	public void setCategoriaLibro(CategoriaLibro categoriaLibro) {
		this.categoriaLibro = categoriaLibro;
	}

	public Date getFechaPublicacion() {
		return this.fechaPublicacion;
	}

	public List<Copia> getCopias() {
		if (this.copias == null) {
			this.copias = new ArrayList<Copia>();
		}
		return this.copias;
	}

	public void setCopias(List<Copia> copias) {
		this.copias = copias;
	}
	
}
