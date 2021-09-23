package pe.dogwalker.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DetalleSolicitud")
public class DetalleSolicitud implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDetalle;
	
	@ManyToOne
	@JoinColumn(name = "idCan", nullable = false)
	private Can can;
	
	@ManyToOne
	@JoinColumn(name = "idSolicitud", nullable = false)
	private Solicitud solicitud;

	public DetalleSolicitud() {
		super();

	}

	public DetalleSolicitud(Long idDetalle, Can can, pe.dogwalker.model.entity.Solicitud solicitud) {
		super();
		this.idDetalle = idDetalle;
		this.can = can;
		this.solicitud = solicitud;
	}

	public Long getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Long idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Can getCan() {
		return can;
	}

	public void setCan(Can can) {
		this.can = can;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

}
