package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Distrito;
import pe.edu.upc.entity.Dueno;
import pe.edu.upc.service.IDistritoService;
import pe.edu.upc.service.IDuenoService;

@Named
@RequestScoped

public class DuenoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IDistritoService diService;
	@Inject
	private IDuenoService duService;
	private Dueno dueno;
	private Distrito distrito;
	private 
	List<Dueno> listaDuenos;
	List<Distrito> listaDistritos;
	
	@PostConstruct
	public void init() {
		this.listaDistritos = new ArrayList<Distrito>();
		this.listaDuenos = new ArrayList<Dueno>();
		this.dueno = new Dueno();
		this.distrito = new Distrito();
		this.listar();
		this.listarDistritos();
	}

	public String nuevoDueno() {
		this.setDueno(new Dueno());
		return "dueno.xhtml";
		
	}
	
	public void insertar() {
		duService.insertar(dueno);
		limpiarDueno();
		this.listar();
	}
	
	public void listar() {
		listaDuenos = duService.listar();
	}

	public void listarDistritos() {
		listaDistritos = diService.listar();
	}
	public void limpiarDueno() {
		this.init();
	}
	
	public void eliminar(Dueno dueno) {
		duService.eliminar(dueno.getId());
		this.listar();
	}

	public IDistritoService getDiService() {
		return diService;
	}

	public void setDiService(IDistritoService diService) {
		this.diService = diService;
	}

	public IDuenoService getDuService() {
		return duService;
	}

	public void setDuService(IDuenoService duService) {
		this.duService = duService;
	}

	public Dueno getDueno() {
		return dueno;
	}

	public void setDueno(Dueno dueno) {
		this.dueno = dueno;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public List<Dueno> getListaDuenos() {
		return listaDuenos;
	}

	public void setListaDuenos(List<Dueno> listaDuenos) {
		this.listaDuenos = listaDuenos;
	}

	public List<Distrito> getListaDistritos() {
		return listaDistritos;
	}

	public void setListaDistritos(List<Distrito> listaDistritos) {
		this.listaDistritos = listaDistritos;
	}

}
