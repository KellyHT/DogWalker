package pe.edu.upc.entity;

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
	private int idDetalle;
	
	@ManyToOne
	@JoinColumn(name = "idCan", nullable = false)
	private Can can;
	
	@ManyToOne
	@JoinColumn(name = "idSolicitud", nullable = false)
	private Solicitud solicitud;

	public DetalleSolicitud() {
		super();
		// TODO Auto-generated constructor stub
		// TODO Auto-generated constructor stub

		// TODO Auto-generated constructor stub

		// TODO Auto-generated constructor stub

	}

	public DetalleSolicitud(int idDetalle, Can can, pe.edu.upc.entity.Solicitud solicitud) {
		super();
		this.idDetalle = idDetalle;
		this.can = can;
		this.solicitud = solicitud;
	}

	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
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
