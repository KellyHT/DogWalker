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
@Table(name="Solicitud")
public class Solicitud implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int idSolicitud;
	
	@ManyToOne
	@JoinColumn(name="idDueno", nullable=false)
	private Dueno dueno;
	
	@ManyToOne
	@JoinColumn(name="idPaseador", nullable=false)
	private Paseador paseador;
	
	private Date fechaSolicitud;
	
	@Column(name="aceptacion", nullable=false, length=50)
	private String aceptacion;
	
	@ManyToOne
	@JoinColumn(name="idEstado", nullable=false)
	private Estado estado;
	
	@ManyToOne
	@JoinColumn(name="idTiempo", nullable=false)
	private Tiempo tiempo;

	public Solicitud() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Solicitud(int idSolicitud, Dueno dueno, Paseador paseador, Date fecha, String aceptacion, Estado estado,
			Tiempo tiempo) {
		super();
		this.idSolicitud = idSolicitud;
		this.dueno = dueno;
		this.paseador = paseador;
		this.fechaSolicitud = fecha;
		this.aceptacion = aceptacion;
		this.estado = estado;
		this.tiempo = tiempo;
	}

	public int getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Dueno getDueno() {
		return dueno;
	}

	public void setDueno(Dueno dueno) {
		this.dueno = dueno;
	}

	public Paseador getPaseador() {
		return paseador;
	}

	public void setPaseador(Paseador paseador) {
		this.paseador = paseador;
	}

	public Date getFecha() {
		return fechaSolicitud;
	}

	public void setFecha(Date fecha) {
		this.fechaSolicitud = fecha;
	}

	public String getAceptacion() {
		return aceptacion;
	}

	public void setAceptacion(String aceptacion) {
		this.aceptacion = aceptacion;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Tiempo getTiempo() {
		return tiempo;
	}

	public void setTiempo(Tiempo tiempo) {
		this.tiempo = tiempo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aceptacion == null) ? 0 : aceptacion.hashCode());
		result = prime * result + ((dueno == null) ? 0 : dueno.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fechaSolicitud == null) ? 0 : fechaSolicitud.hashCode());
		result = prime * result + idSolicitud;
		result = prime * result + ((paseador == null) ? 0 : paseador.hashCode());
		result = prime * result + ((tiempo == null) ? 0 : tiempo.hashCode());
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
		Solicitud other = (Solicitud) obj;
		if (aceptacion == null) {
			if (other.aceptacion != null)
				return false;
		} else if (!aceptacion.equals(other.aceptacion))
			return false;
		if (dueno == null) {
			if (other.dueno != null)
				return false;
		} else if (!dueno.equals(other.dueno))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (fechaSolicitud == null) {
			if (other.fechaSolicitud != null)
				return false;
		} else if (!fechaSolicitud.equals(other.fechaSolicitud))
			return false;
		if (idSolicitud != other.idSolicitud)
			return false;
		if (paseador == null) {
			if (other.paseador != null)
				return false;
		} else if (!paseador.equals(other.paseador))
			return false;
		if (tiempo == null) {
			if (other.tiempo != null)
				return false;
		} else if (!tiempo.equals(other.tiempo))
			return false;
		return true;
	}
	
	
	
}
