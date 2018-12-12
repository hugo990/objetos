package mx.edu.uacm.objsperdidos.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnTransformer;



@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Column
	private String nombre;
	
	@NotNull
	@Email
	@Column
	private String correo;
	
	@NotNull
	@Column
	@ColumnTransformer(write=" MD5(?) ")
	private String contrasena;
	
	@OneToMany(mappedBy="usuario", 
			cascade=CascadeType.ALL, 
			fetch=FetchType.EAGER)
	private List<ObjetoPerdido> objetosPerdidos = 
			new ArrayList<ObjetoPerdido>();

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * @param contrasena the contrasena to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * @return the objetosPerdidos
	 */
	public List<ObjetoPerdido> getObjetosPerdidos() {
		return objetosPerdidos;
	}

	/**
	 * @param objetosPerdidos the objetosPerdidos to set
	 */
	public void setObjetosPerdidos(List<ObjetoPerdido> objetosPerdidos) {
		this.objetosPerdidos = objetosPerdidos;
	}
	
	

}
