package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Estado;
import pe.edu.upc.service.IEstadoService;

@Named
@RequestScoped

public class EstadoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IEstadoService eService;
	private Estado estado;
	List<Estado> listaEstados;
	
	@PostConstruct
	public void init() {
		this.listaEstados = new ArrayList<Estado>();
		this.estado = new Estado();
		this.listar();
	}

	public String nuevoEstado() {
		this.setEstado(new Estado());
		return "estado.xhtml";
	}
	
	public void insertar() {
		eService.insertar(estado);
		limpiarEstado();
	}
	
	public void listar() {
		listaEstados = eService.listar();
	}

	public void limpiarEstado() {
		this.init();
	}
	
	public void eliminar(Estado estado) {
		eService.eliminar(estado.getIdEstado());
		this.listar();
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getListaEstadoes() {
		return listaEstados;
	}

	public void setListaEstadoes(List<Estado> listaEstados) {
		this.listaEstados = listaEstados;
	}
	
}
