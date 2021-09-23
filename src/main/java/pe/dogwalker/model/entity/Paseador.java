package pe.dogwalker.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Paseador")
public class Paseador  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "idDistrito", nullable = false)
	private Distrito distrito;

	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	@Column(name = "apellido", nullable = false, length = 100)
	private String apellido;
	@Column(name = "correo", nullable = false, length = 100)
	private String correo;
	@Column(name = "contrasena", nullable = false, length = 20)
	private String contrasena;
	@Column(name = "fechaDeNacimiento", nullable = false, length = 20)
	private Date fechaDeNacimiento;
	@Column(name = "direccion", nullable = false, length = 150)
	private String direccion;	
	@ManyToOne
	@JoinColumn(name = "idPersonalidad", nullable = false)
	private Personalidad personalidad;
	@Column(name = "biografia", nullable = false, length = 255)
	private String biografia;
	private double montoServicio;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Distrito getDistrito() {
		return distrito;
	}
	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Personalidad getPersonalidad() {
		return personalidad;
	}
	public void setPersonalidad(Personalidad personalidad) {
		this.personalidad = personalidad;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	public double getMontoServicio() {
		return montoServicio;
	}
	public void setMontoServicio(double montoServicio) {
		this.montoServicio = montoServicio;
	}

	
}
