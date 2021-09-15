package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Tiempo;
import pe.edu.upc.service.ITiempoService;

@Named
@RequestScoped

public class TiempoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITiempoService tService;
	private Tiempo tiempo;
	List<Tiempo> listaTiempos;
	
	@PostConstruct
	public void init() {
		this.listaTiempos = new ArrayList<Tiempo>();
		this.tiempo = new Tiempo();
		this.listar();
	}

	public String nuevoTiempo() {
		this.setTiempo(new Tiempo());
		return "tiempo.xhtml";
	}
	
	public void insertar() {
		tService.insertar(tiempo);
		limpiarTiempo();
	}
	
	public void listar() {
		listaTiempos = tService.listar();
	}

	public void limpiarTiempo() {
		this.init();
	}
	
	public void eliminar(Tiempo tiempo) {
		tService.eliminar(tiempo.getIdTiempo());
		this.listar();
	}

	public Tiempo getTiempo() {
		return tiempo;
	}

	public void setTiempo(Tiempo tiempo) {
		this.tiempo = tiempo;
	}

	public List<Tiempo> getListaTiempoes() {
		return listaTiempos;
	}

	public void setListaTiempoes(List<Tiempo> listaTiempos) {
		this.listaTiempos = listaTiempos;
	}
	
}
