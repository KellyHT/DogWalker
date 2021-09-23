package pe.dogwalker.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Caracter")
public class Caracter{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long idCaracter;
	
	@Column(name="nombre", nullable=false, length=50)
	private String nombre;

	public Long getIdCaracter() {
		return idCaracter;
	}
	
	public void setIdCaracter(Long idCaracter) {
		this.idCaracter = idCaracter;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
	
}
