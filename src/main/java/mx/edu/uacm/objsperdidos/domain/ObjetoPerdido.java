package mx.edu.uacm.objsperdidos.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class ObjetoPerdido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Column
	private String nombre;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column
	private Date fechaReporte;
	
	@NotNull
	@Column
	private boolean estaPerdido;
	
	@NotNull
	@Column
	private String descripcion;
	
	@ManyToOne
	private Usuario usuario;
	
	@NotNull
	@Lob
	private String imagen;

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

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
	 * @return the fechaReporte
	 */
	public Date getFechaReporte() {
		return fechaReporte;
	}

	/**
	 * @param fechaReporte the fechaReporte to set
	 */
	public void setFechaReporte(Date fechaReporte) {
		this.fechaReporte = fechaReporte;
	}

	/**
	 * @return the estaPerdido
	 */
	public boolean EstaPerdido() {
		return estaPerdido;
	}

	/**
	 * @param estaPerdido the estaPerdido to set
	 */
	public void setEstaPerdido(boolean estaPerdido) {
		this.estaPerdido = estaPerdido;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	

}
