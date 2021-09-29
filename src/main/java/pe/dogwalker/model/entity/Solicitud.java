package pe.dogwalker.model.entity;

import java.sql.Timestamp;
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
public class Solicitud {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long idSolicitud;
	
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

	
	private Timestamp horaInicio;
	private Timestamp horaFin;

	public Long getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Long idSolicitud) {
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

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Timestamp getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Timestamp horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Timestamp getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Timestamp horaFin) {
		this.horaFin = horaFin;
	}

	
	

}
