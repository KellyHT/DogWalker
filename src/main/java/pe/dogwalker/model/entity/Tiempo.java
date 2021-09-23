package pe.dogwalker.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Tiempo")
public class Tiempo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long idTiempo;
	@Column(name="tipo", nullable=false, length=50)
	private String tipo;
	public Tiempo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tiempo(Long idTiempo, String tipo) {
		super();
		this.idTiempo = idTiempo;
		this.tipo = tipo;
	}
	public Long getIdTiempo() {
		return idTiempo;
	}
	public void setIdTiempo(Long idTiempo) {
		this.idTiempo = idTiempo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTiempo == null) ? 0 : idTiempo.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tiempo other = (Tiempo) obj;
		if (idTiempo == null) {
			if (other.idTiempo != null)
				return false;
		} else if (!idTiempo.equals(other.idTiempo))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	
	
	
}
