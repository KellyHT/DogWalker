package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Calificacion;
import pe.edu.upc.entity.Dueno;
import pe.edu.upc.entity.Paseador;
import pe.edu.upc.service.ICalificacionService;
import pe.edu.upc.service.IDuenoService;
import pe.edu.upc.service.IPaseadorService;

@Named
@RequestScoped

public class CalificacionController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICalificacionService calService;
	@Inject
	private IDuenoService duService;
	@Inject
	private IPaseadorService pasService;
	private Calificacion calificacion;
	private Dueno dueno;
	private Paseador paseador;
	List<Calificacion> listaCalificaciones;
	List<Dueno> listaDuenos;
	List<Paseador> listaPaseadores;
	
	@PostConstruct
	public void init() {
		this.listaCalificaciones = new ArrayList<Calificacion>();
		this.listaDuenos = new ArrayList<Dueno>();
		this.listaPaseadores = new ArrayList<Paseador>();
		this.calificacion = new Calificacion();
		this.dueno = new Dueno();
		this.paseador = new Paseador();
		this.listar();
		this.listarDuenos();
		this.listarPaseadores();
	}

	public String nuevoCalificacion() {
		this.setCalificacion(new Calificacion());
		return "calificacion.xhtml";
	}
	
	public void insertar() {
		calService.insertar(calificacion);
		limpiarCalificacion();
	}
	
	public void listar() {
		listaCalificaciones = calService.listar();
	}
	public void listarDuenos() {
		listaDuenos = duService.listar();
	}
	public void listarPaseadores() {
		listaPaseadores = pasService.listar();
	}

	public void limpiarCalificacion() {
		this.init();
	}
	
	public void eliminar(Calificacion calificacion) {
		calService.eliminar(calificacion.getIdCalificacion());
		this.listar();
	}

	public Calificacion getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}

	public List<Calificacion> getListaCalificaciones() {
		return listaCalificaciones;
	}

	public void setListaCalificaciones(List<Calificacion> listaCalificaciones) {
		this.listaCalificaciones = listaCalificaciones;
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

	public List<Dueno> getListaDuenos() {
		return listaDuenos;
	}

	public void setListaDuenos(List<Dueno> listaDuenos) {
		this.listaDuenos = listaDuenos;
	}

	public List<Paseador> getListaPaseadores() {
		return listaPaseadores;
	}

	public void setListaPaseadores(List<Paseador> listaPaseadores) {
		this.listaPaseadores = listaPaseadores;
	}
	
}
