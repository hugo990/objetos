package mx.edu.uacm.objsperdidos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import mx.edu.uacm.objsperdidos.domain.ObjetoPerdido;
import mx.edu.uacm.objsperdidos.repository.ObjetoPerdidoRepository;
import mx.edu.uacm.objsperdidos.service.ObjetoPerdidoService;
/**
 * Clase de implementacion para el servicio
 * @author Sergio Mena
 *
 */
@Service
public class ObjetoPerdidoServiceImpl implements ObjetoPerdidoService {

	//Inyeccion de dependencias
	@Autowired
	ObjetoPerdidoRepository objetoPerdidoRepository;
	
	
	/*
	 * (non-Javadoc)
	 * @see mx.edu.uacm.objsperdidos.service.ObjetoPerdidoService#guardarObjetoPerdido(mx.edu.uacm.objsperdidos.domain.ObjetoPerdido)
	 */
	public boolean guardarObjetoPerdido(ObjetoPerdido objPerdido) {
		
		boolean bandera = false;

		ObjetoPerdido objetoGuardado = 
				objetoPerdidoRepository.save(objPerdido);

		if(objetoGuardado!=null) 
			bandera = true;
		
		return bandera;
	}


	/*
	 * (non-Javadoc)
	 * @see mx.edu.uacm.objsperdidos.service.ObjetoPerdidoService#obtenerObjetosPerdidos()
	 */
	public List<ObjetoPerdido> obtenerObjetosPerdidos() {
		
		return Lists.newArrayList(objetoPerdidoRepository.findAll());
	}

}
