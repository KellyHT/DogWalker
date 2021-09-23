package pe.dogwalker.model.entity;

import java.io.Serializable;
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
@Table(name = "Usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "idDistrito", nullable = true)
	private Distrito distrito;

	@Column(name = "nombre", nullable = true, length = 100)
	private String nombre;
	@Column(name = "apellido", nullable = true, length = 100)
	private String apellido;
	@Column(name = "correo", nullable = true, length = 100)
	private String correo;
	@Column(name = "contrasena", nullable = true, length = 20)
	private String contrasena;
	@Column(name = "fechaDeNacimiento", nullable = true, length = 20)
	private Date fechaDeNacimiento;
	@Column(name = "direccion", nullable = true, length = 150)
	private String direccion;
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Usuario(Long id, Distrito distrito, String nombre, String apellido, String correo, String contrasena,
			Date fechaDeNacimiento, String direccion) {
		super();
		this.id = id;
		this.distrito = distrito;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasena = contrasena;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.direccion = direccion;
	}
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
	
}
