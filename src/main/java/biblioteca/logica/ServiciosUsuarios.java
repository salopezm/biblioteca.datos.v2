package biblioteca.logica;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import biblioteca.accesoDatos.DaoTipoUsuario;
import biblioteca.accesoDatos.DaoUsuario;
import biblioteca.modelo.TipoUsuario;
import biblioteca.modelo.Usuario;

@ApplicationScoped
public class ServiciosUsuarios {

	@Inject	DaoUsuario 		daoUsuario;
	@Inject	DaoTipoUsuario 	daoTipoUsuario;
	
	public ServiciosUsuarios() { }

	
	// == casos de uso
	
	// CU1 : Registrar Usuario	
	public void registarUsuario(
			String codUsuario, String numDocumento,
			String tipoUsuario, String nombre, String direccion
			) 
		throws Exception {
	
	
		// 3. Valida que no exista un usuario con ese código
		Usuario usuario = daoUsuario.findById(codUsuario);
		if ( usuario != null ) {
			throw new Exception("Ya existe un usuario con ese código");
		}
		
		// 5. Verifica que no exista un usuario con ese número de documento
		// NOTA: hay un NamedQuery en la clase Usuario
		usuario = daoUsuario.buscarPorNumDocumento(numDocumento);
		if ( usuario != null ){
			throw new Exception("Ya existe un usuario con ese Número de documento");
		}
		
		// 7. Verifica que el tipo de usuario ya exista.
		TipoUsuario tipo = daoTipoUsuario.findById(tipoUsuario);
		if (tipo == null){
			throw new Exception("No existe un tipo de usuario con ese nombre");
		}
		
		// 9. Verifica que se hayan ingresado datos para nombre, y dirección
		if ( nombre == null || "".equals(nombre) ) {
			throw new Exception("No se ha ingresado el nombre");
		}		
		if ( direccion == null | "".equals(direccion) ) {
			throw new Exception("No se ha ingresado la dirección");
		}
		
		// 10. Registra el usuario en el sistema
				
		daoUsuario.beginTransaction();
		
		usuario = new Usuario();
		usuario.setCodigo(codUsuario);
		usuario.setNumDocumento(numDocumento);
		usuario.setNombre(nombre);
		usuario.setDireccion(direccion);
		usuario.setTipo(tipo);
		daoUsuario.create(usuario);
		
		tipo.getUsuarios().add(usuario);
		daoTipoUsuario.update(tipo);
		
		daoUsuario.commit();
				
	}
	
}
