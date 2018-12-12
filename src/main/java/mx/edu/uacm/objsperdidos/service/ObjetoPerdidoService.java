package mx.edu.uacm.objsperdidos.service;

import java.util.List;

import mx.edu.uacm.objsperdidos.domain.ObjetoPerdido;

/**
 * 
 * Interfaz utilizada para escribir
 * las firmas de los metodos a utilizar de los
 * objetos perdidos
 * @author Sergio Mena
 *
 */
public interface ObjetoPerdidoService {

	/**
	 * Metodo utilizado para guardar el objeto perdido
	 * @param objPerdido
	 * @return boolean si es verdadero
	 */
	boolean guardarObjetoPerdido(ObjetoPerdido objPerdido);
	
	
	/**
	 * Metodo utilizado para obtener todos
	 * los objetos perdidos
	 * @return
	 */
	List<ObjetoPerdido> obtenerObjetosPerdidos();
	
}
