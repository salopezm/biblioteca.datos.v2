package biblioteca.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Prestamo {
	@Id
	private long id;

	@Temporal(TemporalType.DATE)
	private Date fechaPrestamo;

	@Temporal(TemporalType.DATE)	
	private Date fechaADevolver;

	@Temporal(TemporalType.DATE)
	private Date fechaDevolucion;

	@OneToOne(mappedBy="prestamo",optional=true)
	private Multa multa;

	@ManyToOne
	@JoinColumn(name="id_copia")
	private Copia copia;

	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	public Prestamo() {
	
	}
	
	public void setId(long value) {
		this.id = value;
	}

	public long getId() {
		return this.id;
	}

	public void setFechaPrestamo(Date value) {
		this.fechaPrestamo = value;
	}

	public Date getFechaPrestamo() {
		return this.fechaPrestamo;
	}

	public void setFechaADevolver(Date value) {
		this.fechaADevolver = value;
	}

	public Date getFechaADevolver() {
		return this.fechaADevolver;
	}

	public void setFechaDevolucion(Date value) {
		this.fechaDevolucion = value;
	}

	public Date getFechaDevolucion() {
		return this.fechaDevolucion;
	}

	public void setMulta(Multa value) {
		this.multa = value;
	}

	public Multa getMulta() {
		return this.multa;
	}

	public void setCopia(Copia value) {
		this.copia = value;
	}

	public Copia getCopia() {
		return this.copia;
	}

	public void setUsuario(Usuario value) {
		this.usuario = value;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

}
