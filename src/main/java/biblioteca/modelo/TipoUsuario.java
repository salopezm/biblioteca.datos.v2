package biblioteca.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TipoUsuario {

	@Id
	public String id;

	private String nombre;

	@OneToMany(mappedBy="tipo")
	private List<Usuario> usuarios;

	@OneToMany(mappedBy="tipoUsuario")
	private List<Reglamento> reglamentos;

	
	public TipoUsuario() {
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

	public List<Usuario> getUsuarios() {
		if (this.usuarios == null) {
			this.usuarios = new ArrayList<Usuario>();
		}
		return this.usuarios;
	}
	
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
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
}
