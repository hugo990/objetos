package mx.edu.uacm.objsperdidos.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mx.edu.uacm.objsperdidos.domain.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	Usuario findByCorreo(String correo);
	
	
	@Query(value="select * from Usuario where correo= :correo AND contrasena = MD5(:pass)", nativeQuery=true)
	Usuario findByCorreoAndContrasena(@Param("correo") String email, 
			@Param("pass") String contrasenia);
}
