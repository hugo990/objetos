package mx.edu.uacm.objsperdidos.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.uacm.objsperdidos.domain.Usuario;
import mx.edu.uacm.objsperdidos.repository.UsuarioRepository;
import mx.edu.uacm.objsperdidos.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private Logger log = LogManager.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	UsuarioRepository usuarioRepository;

	/*
	 * (non-Javadoc)
	 * @see mx.edu.uacm.objsperdidos.service.UsuarioService#obtenerUsuarioPorCorreoYContrasena(java.lang.String, java.lang.String)
	 */
	@Override
	public Usuario obtenerUsuarioPorCorreoYContrasena(String correo, String contrasena) {
		
		Usuario usuario = usuarioRepository.findByCorreoAndContrasena(correo, contrasena);
		
		if(usuario == null) {
			log.info("No existe el usuario");
		} else {
			return usuario;
		}
		 return usuario;
	}

	@Override
	public Boolean guardarUsuario(Usuario usuario) {
		
		Usuario nuevoUsuario = usuarioRepository.save(usuario);
		
		if(nuevoUsuario != null) {
			return true;
		}
		
		return false;
		
	}

}
