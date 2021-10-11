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
public class Copia {

	@Id
	private long codigoBarras;

	@Temporal(TemporalType.DATE)
	private Date fechaAdquisicion;

	@ManyToOne
	@JoinColumn(name="id_libro")
	private Libro libro;

	private boolean disponible;

	@OneToMany(mappedBy="copia", cascade={CascadeType.ALL, CascadeType.REMOVE})
	private List<Prestamo> prestamos;

	public void setCodigoBarras(long value) {
		this.codigoBarras = value;
	}

	public long getCodigoBarras() {
		return this.codigoBarras;
	}

	public void setFechaAdquisicion(Date value) {
		this.fechaAdquisicion = value;
	}

	public Date getFechaAdquisicion() {
		return this.fechaAdquisicion;
	}

	public void setLibro(Libro value) {
		this.libro = value;
	}

	public Libro getLibro() {
		return this.libro;
	}

	public void setDisponible(boolean value) {
		this.disponible = value;
	}

	public boolean isDisponible() {
		return this.disponible;
	}

	public List<Prestamo> getPrestamos() {
		if (this.prestamos == null) {
			this.prestamos = new ArrayList<Prestamo>();
		}
		return this.prestamos;
	}
	
	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

}
