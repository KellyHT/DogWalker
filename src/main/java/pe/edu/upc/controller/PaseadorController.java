package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Distrito;
import pe.edu.upc.entity.Paseador;
import pe.edu.upc.entity.Personalidad;
import pe.edu.upc.service.IDistritoService;
import pe.edu.upc.service.IPaseadorService;
import pe.edu.upc.service.IPersonalidadService;

@Named
@RequestScoped

public class PaseadorController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IDistritoService diService;
	@Inject
	private IPaseadorService duService;
	@Inject
	private IPersonalidadService peService;
	private Paseador paseador;
	private Distrito distrito;
	private Personalidad personalidad; 
	List<Paseador> listaPaseadores;
	List<Distrito> listaDistritos;
	List<Personalidad> listaPersonalidades;
	
	@PostConstruct
	public void init() {
		this.listaDistritos = new ArrayList<Distrito>();
		this.listaPaseadores = new ArrayList<Paseador>();
		this.listaPersonalidades=new ArrayList<Personalidad>();
		this.paseador = new Paseador();
		this.distrito = new Distrito();
		this.personalidad=new Personalidad();
		this.listar();
		this.listarDistritos();
		this.listarPersonalidades();
	}

	public String nuevoPaseador() {
		this.setPaseador(new Paseador());
		return "paseador.xhtml";
		
	}
	
	public void insertar() {
		duService.insertar(paseador);
		limpiarPaseador();
		this.listar();
	}
	
	public void listar() {
		listaPaseadores = duService.listar();
	}

	public void listarDistritos() {
		listaDistritos = diService.listar();
	}
	
	public void listarPersonalidades() {
		listaPersonalidades = peService.listar();
	}
	public void limpiarPaseador() {
		this.init();
	}
	
	public void eliminar(Paseador paseador) {
		duService.eliminar(paseador.getId());
		this.listar();
	}

	public Paseador getPaseador() {
		return paseador;
	}

	public void setPaseador(Paseador paseador) {
		this.paseador = paseador;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public Personalidad getPersonalidad() {
		return personalidad;
	}

	public void setPersonalidad(Personalidad personalidad) {
		this.personalidad = personalidad;
	}

	public List<Paseador> getListaPaseadores() {
		return listaPaseadores;
	}

	public void setListaPaseadores(List<Paseador> listaPaseadores) {
		this.listaPaseadores = listaPaseadores;
	}

	public List<Distrito> getListaDistritos() {
		return listaDistritos;
	}

	public void setListaDistritos(List<Distrito> listaDistritos) {
		this.listaDistritos = listaDistritos;
	}

	public List<Personalidad> getListaPersonalidades() {
		return listaPersonalidades;
	}

	public void setListaPersonalidades(List<Personalidad> listaPersonalidades) {
		this.listaPersonalidades = listaPersonalidades;
	}

}
