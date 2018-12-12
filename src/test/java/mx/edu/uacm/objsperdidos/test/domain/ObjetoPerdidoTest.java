package mx.edu.uacm.objsperdidos.test.domain;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.edu.uacm.objsperdidos.domain.ObjetoPerdido;
import mx.edu.uacm.objsperdidos.repository.ObjetoPerdidoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ObjetoPerdidoTest {
	
	
	//Inyeccion de dependencias
	@Autowired
	ObjetoPerdidoRepository objetoPerdidoRepository;
	
	@Test
	public void testGuardarObjetoPerdido() {
		ObjetoPerdido objPerdido = 
				new ObjetoPerdido();
		//objPerdido.
		//setId(new Long(1));
		objPerdido.
		setFechaReporte(new Date());
		objPerdido.setNombre("Sergio M.");
		
		//Guardar el obj en bd
		objetoPerdidoRepository.save(objPerdido);
		
		
		//buscar
		//borrar
		//actualizar
	}
	
	//metodo de prueba para buscar
	
	//metodo de prueba para borrar
	
	//metodo de prueba para actualizar
	
	//UTILIZAR ASERCIONES

}
