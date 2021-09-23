package pe.dogwalker.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Personalidad")
public class Personalidad{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersonalidad;
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	public Long getIdPersonalidad() {
		return idPersonalidad;
	}

	public void setIdPersonalidad(Long idPersonalidad) {
		this.idPersonalidad = idPersonalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


}
