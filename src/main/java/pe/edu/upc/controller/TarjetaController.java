package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Tarjeta;
import pe.edu.upc.service.ITarjetaService;

@Named
@RequestScoped

public class TarjetaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITarjetaService tService;
	private Tarjeta tarjeta;
	List<Tarjeta> listaTarjetas;
	
	@PostConstruct
	public void init() {
		this.listaTarjetas = new ArrayList<Tarjeta>();
		this.tarjeta = new Tarjeta();
		this.listar();
	}

	public String nuevoTarjeta() {
		this.setTarjeta(new Tarjeta());
		return "tarjeta.xhtml";
	}
	
	public void insertar() {
		tService.insertar(tarjeta);
		limpiarTarjeta();
	}
	
	public void listar() {
		listaTarjetas = tService.listar();
	}

	public void limpiarTarjeta() {
		this.init();
	}
	
	public void eliminar(Tarjeta tarjeta) {
		tService.eliminar(tarjeta.getIdTarjeta());
		this.listar();
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public List<Tarjeta> getListaTarjetaes() {
		return listaTarjetas;
	}

	public void setListaTarjetaes(List<Tarjeta> listaTarjetas) {
		this.listaTarjetas = listaTarjetas;
	}
	
}
