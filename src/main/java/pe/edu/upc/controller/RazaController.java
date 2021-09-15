package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Raza;
import pe.edu.upc.service.IRazaService;

@Named
@RequestScoped

public class RazaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IRazaService rService;
	private Raza raza;
	List<Raza> listaRazas;
	
	@PostConstruct
	public void init() {
		this.listaRazas = new ArrayList<Raza>();
		this.raza = new Raza();
		this.listar();
	}

	public String nuevoRaza() {
		this.setRaza(new Raza());
		return "raza.xhtml";
	}
	
	public void insertar() {
		rService.insertar(raza);
		limpiarRaza();
	}
	
	public void listar() {
		listaRazas = rService.listar();
	}

	public void limpiarRaza() {
		this.init();
	}
	
	public void eliminar(Raza raza) {
		rService.eliminar(raza.getIdRaza());
		this.listar();
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

	public List<Raza> getListaRazaes() {
		return listaRazas;
	}

	public void setListaRazaes(List<Raza> listaRazas) {
		this.listaRazas = listaRazas;
	}
	
}
