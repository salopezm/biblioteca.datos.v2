package biblioteca.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reglamento {

	@Id
	@GeneratedValue
	private long id;

	private int diasPrestamo;

	private double multaDiaria;

	@ManyToOne
	@JoinColumn(name = "id_categoria_Libro")
	private CategoriaLibro categoriaLibro;

	@ManyToOne
	@JoinColumn(name = "id_tipo_usuario")
	private TipoUsuario tipoUsuario;

	public Reglamento() {
	}
	
	public void setId(long value) {
		this.id = value;
	}

	public long getId() {
		return this.id;
	}

	public void setDiasPrestamo(int value) {
		this.diasPrestamo = value;
	}

	public int getDiasPrestamo() {
		return this.diasPrestamo;
	}

	public void setMultaDiaria(double value) {
		this.multaDiaria = value;
	}

	public double getMultaDiaria() {
		return this.multaDiaria;
	}

	public void setCategoriaLibro(CategoriaLibro value) {
		this.categoriaLibro = value;
	}

	public CategoriaLibro getCategoriaLibro() {
		return this.categoriaLibro;
	}

	public void setTipoUsuario(TipoUsuario value) {
		this.tipoUsuario = value;
	}

	public TipoUsuario getTipoUsuario() {
		return this.tipoUsuario;
	}

}
