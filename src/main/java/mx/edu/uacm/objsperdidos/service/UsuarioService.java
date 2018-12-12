package mx.edu.uacm.objsperdidos.service;

import mx.edu.uacm.objsperdidos.domain.Usuario;

/**
 * Definicion de los contratos de servicio de usuario 
 * @author Clases
 *
 */
public interface UsuarioService {
	
	Boolean guardarUsuario(Usuario usuario);
	
	/**
	 * Metodo utilizado para obtener el usuario a traves
	 * de su correo electronico y password
	 * @param correo 
	 * @param contrasena 
	 * @return Usuario 
	 */
	Usuario obtenerUsuarioPorCorreoYContrasena(String correo,
			String contrasena);
}
