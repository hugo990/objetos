package mx.edu.uacm.objsperdidos.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import mx.edu.uacm.objsperdidos.ObjetosPerdidosApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=ObjetosPerdidosApplication.class)
@AutoConfigureMockMvc
public class UsuarioControllerTest {
	
	private final static Logger log = 
			LogManager.getLogger(UsuarioControllerTest.class);
	
	//inyeccion de depedencias
	@Autowired
	private MockMvc mvc;
	
	
	@Test
	public void testLogin() throws Exception {
		log.debug("Entrando al metodo testLogin");
		
		
		
		ResultActions resultado = mvc.perform(post("/usuario/login").
				param("correo", "aym.uacm@gmail.com").
				param("contrasena", "uacm2018"));
		
		MvcResult mvcResult = resultado.andReturn();
		
		MockHttpSession session = (MockHttpSession) mvcResult.getRequest().getSession();
		
		log.info("********* Atributo ******* :" + session.getAttribute("userLoggedIn"));
		
		//Asercion para comprobar que el atributo no sea nulo
		Assert.assertNotNull(session.getAttribute("userLoggedIn"));
		

	}
	
		

}
