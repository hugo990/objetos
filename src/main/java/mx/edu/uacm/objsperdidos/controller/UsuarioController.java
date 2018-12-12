package mx.edu.uacm.objsperdidos.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mx.edu.uacm.objsperdidos.domain.Usuario;
import mx.edu.uacm.objsperdidos.domain.ValidarDatosUsuario;
import mx.edu.uacm.objsperdidos.service.UsuarioService;

@Controller
@RequestMapping("/")
public class UsuarioController {
	
	private static Logger log = LogManager.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private HttpSession httpSession;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new  ValidarDatosUsuario());
    }
	
	@GetMapping("/login")
	public ModelAndView mostrarLogin(Map<String, Object> model, Usuario usuario) { 
		log.info(httpSession.getAttribute("userLoggedIn"));
		if(httpSession.getAttribute("userLoggedIn") == null) {
			return new ModelAndView("login");
		} else {
			return new ModelAndView("redirect:/");
		}
		
	}
	
	@PostMapping("/login")
	public ModelAndView login(@Validated Usuario usuario, BindingResult result) {
		
		if (result.hasErrors()) {
			Usuario usuarioObtenido = usuarioService.obtenerUsuarioPorCorreoYContrasena(
					usuario.getCorreo(), usuario.getContrasena());
			
			if(usuarioObtenido != null) {
				httpSession.setAttribute("userLoggedIn", usuarioObtenido.getCorreo());
				httpSession.setAttribute("userID", usuarioObtenido.getId());
				return new ModelAndView("redirect:/");
			}
		}
		
		return new ModelAndView("login");
		
	}
	
	
	@GetMapping("/registro")
	public ModelAndView mostrarRegistro(Usuario usuario) { 
		log.info(httpSession.getAttribute("userLoggedIn"));
		if(httpSession.getAttribute("userLoggedIn") == null) {
			return new ModelAndView("registro");
		} else {
			return new ModelAndView("redirect:/");
		}
		
	}
	
	

	
	@PostMapping("/registro")
	public ModelAndView registro(@Valid Usuario usuario, BindingResult result) {
		
		if(result.hasErrors()) {
			return new ModelAndView("registro");
		} else {
			if(usuarioService.guardarUsuario(usuario) == true) {
				return new ModelAndView("redirect:/login");
			}
		}
		
		return new ModelAndView("registro");
	}
	
	
	@GetMapping("/logout")
	public String logout() {
		httpSession.removeAttribute("userLoggedIn");
		return "redirect:/";
	}
	
	
	/*@PostMapping("/recibir")
	public String recibe(Map<String, Object> model, @RequestParam("colores") List<String> colores) {
		
		log.debug("El tamaño de la lista es" + colores.size());
		
		
		
		return "redirect:/";
		
	}*/
	
	
	

}
