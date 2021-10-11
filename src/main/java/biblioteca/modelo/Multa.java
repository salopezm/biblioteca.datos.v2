package biblioteca.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Multa {

	@Id
	@GeneratedValue
	private long id;

	private double valor;

	@Temporal(TemporalType.DATE)
	private Date fechaMulta;

	@OneToOne
	@JoinColumn(name="id_prestamo")
	private Prestamo prestamo;
	
	public Multa() {

	}

	public void setValor(double value) {
		this.valor = value;
	}

	public double getValor() {
		return this.valor;
	}

	public void setFechaMulta(Date value) {
		this.fechaMulta = value;
	}

	public Date getFechaMulta() {
		return this.fechaMulta;
	}

	public void setPrestamo(Prestamo value) {
		this.prestamo = value;
	}

	public Prestamo getPrestamo() {
		return this.prestamo;
	}

}
