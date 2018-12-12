package mx.edu.uacm.objsperdidos.test.service;

import java.util.Date;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.edu.uacm.objsperdidos.ObjetosPerdidosApplication;
import mx.edu.uacm.objsperdidos.domain.ObjetoPerdido;
import mx.edu.uacm.objsperdidos.service.ObjetoPerdidoService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=ObjetosPerdidosApplication.class)
public class ObjetoPerdidoServiceTest {
	
	
	//Inyeccion de dependencias

	@Autowired
	ObjetoPerdidoService objetoPerdidoService;
	
	public void testProbarGuardarObjetoPerdido() {
		
		//objetoPerdidoService.g
		ObjetoPerdido objPerdido = 
				new ObjetoPerdido();
		//objPerdido.
		//setId(new Long(1));
		objPerdido.
		setFechaReporte(new Date());
		objPerdido.setNombre("Sergio M.");
		
		objetoPerdidoService.guardarObjetoPerdido(objPerdido);
		
	}
	
	/*
	 * TODO los metodos 
	 */

}
