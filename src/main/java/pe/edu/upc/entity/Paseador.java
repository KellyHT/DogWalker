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
import javax.persistence.Table;

@Entity
@Table(name = "Paseador")
public class Paseador implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
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
	public Paseador() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Paseador(int id, Distrito distrito, String nombre, String apellido, String correo, String contrasena,
			Date fechaDeNacimiento, String direccion, Personalidad personalidad, String biografia,
			double montoServicio) {
		super();
		this.id = id;
		this.distrito = distrito;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasena = contrasena;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.direccion = direccion;
		this.personalidad = personalidad;
		this.biografia = biografia;
		this.montoServicio = montoServicio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((biografia == null) ? 0 : biografia.hashCode());
		result = prime * result + ((contrasena == null) ? 0 : contrasena.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((distrito == null) ? 0 : distrito.hashCode());
		result = prime * result + ((fechaDeNacimiento == null) ? 0 : fechaDeNacimiento.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(montoServicio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((personalidad == null) ? 0 : personalidad.hashCode());
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
		Paseador other = (Paseador) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (biografia == null) {
			if (other.biografia != null)
				return false;
		} else if (!biografia.equals(other.biografia))
			return false;
		if (contrasena == null) {
			if (other.contrasena != null)
				return false;
		} else if (!contrasena.equals(other.contrasena))
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (distrito == null) {
			if (other.distrito != null)
				return false;
		} else if (!distrito.equals(other.distrito))
			return false;
		if (fechaDeNacimiento == null) {
			if (other.fechaDeNacimiento != null)
				return false;
		} else if (!fechaDeNacimiento.equals(other.fechaDeNacimiento))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(montoServicio) != Double.doubleToLongBits(other.montoServicio))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (personalidad == null) {
			if (other.personalidad != null)
				return false;
		} else if (!personalidad.equals(other.personalidad))
			return false;
		return true;
	}
	
	
	
	
	
}
