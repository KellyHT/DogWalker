package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Caracter")
public class Caracter implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int idCaracter;
	
	@Column(name="nombre", nullable=false, length=50)
	private String nombre;
	public Caracter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Caracter(int idCaracter, String nombre) {
		super();
		this.idCaracter = idCaracter;
		this.nombre = nombre;
	}
	
	public int getIdCaracter() {
		return idCaracter;
	}
	
	public void setIdCaracter(int idCaracter) {
		this.idCaracter = idCaracter;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCaracter;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Caracter other = (Caracter) obj;
		if (idCaracter != other.idCaracter)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	
}
