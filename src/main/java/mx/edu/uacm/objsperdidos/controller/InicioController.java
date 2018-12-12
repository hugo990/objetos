package mx.edu.uacm.objsperdidos.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.edu.uacm.objsperdidos.domain.ObjetoPerdido;
import mx.edu.uacm.objsperdidos.service.ObjetoPerdidoService;

@Controller
@RequestMapping("/inicio")
public class InicioController {

	//inyeccion de depencias
	@Autowired
	ObjetoPerdidoService objetoPerdidoService;
	
	
	@GetMapping
	public String iniciar(Map <String, Object> model) {
		
		List<ObjetoPerdido> listadoObjetos = 
				objetoPerdidoService.obtenerObjetosPerdidos();
		
		model.put("objsPerdidos", listadoObjetos);
		
		
		return "index";
	}
	
	
}
