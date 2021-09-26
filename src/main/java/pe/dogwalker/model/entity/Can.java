package pe.dogwalker.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Can {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long idCan;
	
	@ManyToOne /// cambiar
	@JoinColumn(name="idDueno", nullable=true)
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

	
	public Long getIdCan() {
		return idCan;
	}

	public void setIdCan(Long idCan) {
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

}
