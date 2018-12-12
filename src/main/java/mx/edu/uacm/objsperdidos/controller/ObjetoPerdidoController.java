package mx.edu.uacm.objsperdidos.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import mx.edu.uacm.objsperdidos.domain.ObjetoPerdido;
import mx.edu.uacm.objsperdidos.service.ObjetoPerdidoService;

@Controller
@RequestMapping("/")
public class ObjetoPerdidoController {
	
	private static Logger log = LogManager.getLogger(ObjetoPerdido.class); 
	
	//inyeccion de depencias
	@Autowired
	ObjetoPerdidoService objetoPerdidoService;
	
	@Autowired
	private HttpSession httpSession;
	
	@GetMapping("/nuevo")
	public ModelAndView mostrarNuevo(Map <String, Object> model) {
		
		if(httpSession.getAttribute("userLoggedIn") != null) {
			model.put("id", httpSession.getAttribute("userID"));

			return new ModelAndView("nuevo");
		}
		
		return new ModelAndView("redirect:/");
	}
	
	@PostMapping("/guardarObjeto")
	public ModelAndView guardarObjetoPerdido(ObjetoPerdido objetoPerdido, @RequestParam("archivo") MultipartFile file) throws IOException {
		
		
		if(httpSession.getAttribute("userLoggedIn") != null) {
			objetoPerdido.setImagen(Base64.getEncoder().encodeToString(file.getBytes()));
			objetoPerdidoService.guardarObjetoPerdido(objetoPerdido);
			
			return new ModelAndView("redirect:/");
			
		}
		
		return new ModelAndView("login");
	}
	
	@GetMapping("/")
	public String obtenerObjsPerdidosTodos(Map <String, Object> model) {
		
		List<ObjetoPerdido> listadoObjetos = 
				objetoPerdidoService.obtenerObjetosPerdidos();
			
		
		model.put("objsPerdidos", listadoObjetos);
		
		return "index";
	}
	
	

}
