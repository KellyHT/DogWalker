package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Calificacion")
public class Calificacion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int idCalificacion;
	
	@Column(name="comentario", nullable=false, length=255)
	private String comentario;
	
	private int puntuacion;
	
	@ManyToOne
	@JoinColumn(name="idDueno", nullable=false)
	private Dueno dueno;
	
	@ManyToOne
	@JoinColumn(name="idPaseador", nullable=false)
	private Paseador paseador;

	public Calificacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Calificacion(int idCalificacion, String comentario, int puntuacion, Dueno dueno, Paseador paseador) {
		super();
		this.idCalificacion = idCalificacion;
		this.comentario = comentario;
		this.puntuacion = puntuacion;
		this.dueno = dueno;
		this.paseador = paseador;
	}

	public int getIdCalificacion() {
		return idCalificacion;
	}

	public void setIdCalificacion(int idCalificacion) {
		this.idCalificacion = idCalificacion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
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
	

	
}
