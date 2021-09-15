package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Can implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int idCan;
	
	@ManyToOne
	@JoinColumn(name="idDueno", nullable=false)
	private Dueno dueno;
	
	@ManyToOne
	@JoinColumn(name="idCaracter", nullable=false)
	private Caracter caracter;
	
	@ManyToOne
	@JoinColumn(name="idRaza", nullable=false)
	private Raza raza;
	
	@Column(name="nombre", nullable=false, length=50)
	private String nombre;
	private Float tamano;
	
	@Column(name="descripcion", nullable=false, length=120)
	private String descripcion;
	
	private Date fechaNacimiento;

	public Can() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Can(int idCan, Dueno dueno, Caracter caracter, Raza raza, String nombre, Float tamano, String descripcion,
			Date fechaNacimiento) {
		super();
		this.idCan = idCan;
		this.dueno = dueno;
		this.caracter = caracter;
		this.raza = raza;
		this.nombre = nombre;
		this.tamano = tamano;
		this.descripcion = descripcion;
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getIdCan() {
		return idCan;
	}

	public void setIdCan(int idCan) {
		this.idCan = idCan;
	}

	public Dueno getDueno() {
		return dueno;
	}

	public void setDueno(Dueno dueno) {
		this.dueno = dueno;
	}

	public Caracter getCaracter() {
		return caracter;
	}

	public void setCaracter(Caracter caracter) {
		this.caracter = caracter;
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getTamano() {
		return tamano;
	}

	public void setTamano(Float tamano) {
		this.tamano = tamano;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caracter == null) ? 0 : caracter.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((dueno == null) ? 0 : dueno.hashCode());
		result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
		result = prime * result + idCan;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((raza == null) ? 0 : raza.hashCode());
		result = prime * result + ((tamano == null) ? 0 : tamano.hashCode());
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
		Can other = (Can) obj;
		if (caracter == null) {
			if (other.caracter != null)
				return false;
		} else if (!caracter.equals(other.caracter))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (dueno == null) {
			if (other.dueno != null)
				return false;
		} else if (!dueno.equals(other.dueno))
			return false;
		if (fechaNacimiento == null) {
			if (other.fechaNacimiento != null)
				return false;
		} else if (!fechaNacimiento.equals(other.fechaNacimiento))
			return false;
		if (idCan != other.idCan)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (raza == null) {
			if (other.raza != null)
				return false;
		} else if (!raza.equals(other.raza))
			return false;
		if (tamano == null) {
			if (other.tamano != null)
				return false;
		} else if (!tamano.equals(other.tamano))
			return false;
		return true;
	}
	
}
