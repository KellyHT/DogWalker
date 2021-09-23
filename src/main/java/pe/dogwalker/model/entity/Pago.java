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
@Table(name = "Pago")
public class Pago  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long idPago;
	
	private Date fechaPago;
	
	private Float montoFinal;
	
	@ManyToOne
	@JoinColumn(name="idTarjeta", nullable=false)
	private Tarjeta tarjeta;
	
	
	@ManyToOne
	@JoinColumn(name="idSolicitud", nullable=false)
	private Solicitud solicitud;
	
	@Column(name="name", nullable=false, length=100)
	private String name;
	
	@Column(name="cardNumero", nullable=false, length=25)
	private String cardNumero; 
	private int cvv;
	
	public Long getIdPago() {
		return idPago;
	}
	public void setIdPago(Long idPago) {
		this.idPago = idPago;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public Float getMontoFinal() {
		return montoFinal;
	}
	public void setMontoFinal(Float montoFinal) {
		this.montoFinal = montoFinal;
	}
	public Tarjeta getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	public Solicitud getSolicitud() {
		return solicitud;
	}
	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardNumero() {
		return cardNumero;
	}
	public void setCardNumero(String cardNumero) {
		this.cardNumero = cardNumero;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

}
