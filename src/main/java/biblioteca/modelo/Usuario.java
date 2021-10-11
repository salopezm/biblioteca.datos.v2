package biblioteca.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery( name="usuario.buscarPorNumDocumento", 
			query="select u from Usuario u where u.numDocumento = :numDocumento" )
})
public class Usuario {

	@Id
	private String codigo;

	private String numDocumento;

	private String nombre;

	private String direccion;

	@ManyToOne
	@JoinColumn(name = "id_tipo_usuario")
	private TipoUsuario tipo;

	@OneToMany(mappedBy="usuario")
	private List<Prestamo> prestamos;

	public Usuario() {

	}
	
	public void setCodigo(String value) {
		this.codigo = value;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setNumDocumento(String value) {
		this.numDocumento = value;
	}

	public String getNumDocumento() {
		return this.numDocumento;
	}

	public void setNombre(String value) {
		this.nombre = value;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setDireccion(String value) {
		this.direccion = value;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setTipo(TipoUsuario value) {
		this.tipo = value;
	}

	public TipoUsuario getTipo() {
		return this.tipo;
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
