package pe.dogwalker.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Tiempo")
public class Tiempo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long idTiempo;
	@Column(name="tiempo", nullable=false, length=100)
	private String tiempo;

	public Long getIdTiempo() {
		return idTiempo;
	}
	public void setIdTiempo(Long idTiempo) {
		this.idTiempo = idTiempo;
	}
	public String getTipo() {
		return tiempo;
	}
	public void setTipo(String tipo) {
		this.tiempo = tipo;
	}

	
}
