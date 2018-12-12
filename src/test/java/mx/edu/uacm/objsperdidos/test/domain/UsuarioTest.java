package mx.edu.uacm.objsperdidos.test.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.edu.uacm.objsperdidos.domain.ObjetoPerdido;
import mx.edu.uacm.objsperdidos.domain.Usuario;
import mx.edu.uacm.objsperdidos.repository.UsuarioRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UsuarioTest {

	
	private Logger log = LogManager.getLogger(UsuarioTest.class);
	
	//Inyeccion de dependencias
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Test
	public void testGuardarUsuario() {
		
		Usuario usuario = new Usuario();
		
		usuario.setCorreo("aym.uacm4@gmail.com");
		usuario.setNombre("profe");
		usuario.setContrasena("uacm2018");
		
		
		ObjetoPerdido objUSB = new ObjetoPerdido();
		objUSB.setDescripcion("USB");
		objUSB.setFechaReporte(new Date());
		objUSB.setNombre("USB 16G");
		objUSB.setUsuario(usuario);

		

		ObjetoPerdido mouse = new ObjetoPerdido();
		mouse.setDescripcion("mouse");
		mouse.setFechaReporte(new Date());
		mouse.setNombre("mouse inalambrico");
		mouse.setUsuario(usuario);
		
		
		List<ObjetoPerdido> objetosPerdidos = 
				new ArrayList<ObjetoPerdido>();
		
		objetosPerdidos.add(objUSB);
		objetosPerdidos.add(mouse);
		
		usuario.setObjetosPerdidos(objetosPerdidos);
		
		//guardo
		usuarioRepository.save(usuario);
		
		
	}
	
	@Test
	public void testObtenerObjetosPerdidos() {
		
	
		
		Usuario usuario = usuarioRepository.
				findByCorreo("aym.uacm4@gmail.com"); //usuarioRepository.findById(new Long(2));
		
		//va a ser un select
				List<ObjetoPerdido> objsObtenidos = 
						usuario.getObjetosPerdidos();
				
				for (ObjetoPerdido objPerdido : objsObtenidos) {
					log.info("Objeto perdido nombre: " + 
							objPerdido.getNombre());
					
					log.info("El nombre del usuario: " +
							objPerdido.getUsuario().getNombre());
				}
	}
		
}
