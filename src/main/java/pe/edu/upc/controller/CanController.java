package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Can;
import pe.edu.upc.entity.Caracter;
import pe.edu.upc.entity.Dueno;
import pe.edu.upc.entity.Raza;
import pe.edu.upc.service.ICanService;
import pe.edu.upc.service.ICaracterService;
import pe.edu.upc.service.IDuenoService;
import pe.edu.upc.service.IRazaService;

@Named
@RequestScoped

public class CanController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICanService cService;
	@Inject
	private ICaracterService carService;
	@Inject
	private IRazaService raService;
	@Inject
	private IDuenoService duService;
	private Can can;
	private Caracter caracter;
	private Raza raza;
	private Dueno dueno;
	List<Can> listaCans;
	List<Caracter> listaCaracteres;
	List<Raza> listaRazas;
	List<Dueno> listaduenos;
	
	@PostConstruct
	public void init() {
		this.listaCans = new ArrayList<Can>();
		this.listaCaracteres =  new ArrayList<Caracter>();
		this.listaRazas = new ArrayList<Raza>();
		this.listaduenos = new ArrayList<Dueno>();
		this.can = new Can();
		this.caracter = new Caracter();
		this.raza = new Raza();
		this.dueno = new Dueno();
		this.listar();
		this.listarCaracteres();
		this.listarRazas();
		this.listarDuenos();
	}

	public String nuevoCan() {
		this.setCan(new Can());
		return "can.xhtml";
	}
	
	public void insertar() {
		cService.insertar(can);
		limpiarCan();
	}
	
	public void listar() {
		listaCans = cService.listar();
	}
	public void listarCaracteres() {
		listaCaracteres = carService.listar();
	}
	public void listarRazas() {
		listaRazas = raService.listar();
	}
	public void listarDuenos() {
		listaduenos =duService.listar();
	}

	public void limpiarCan() {
		this.init();
	}
	
	
	public void eliminar(Can can) {
		cService.eliminar(can.getIdCan());
		this.listar();
	}

	public Can getCan() {
		return can;
	}

	public void setCan(Can can) {
		this.can = can;
	}

	public List<Can> getListaCans() {
		return listaCans;
	}

	public void setListaCans(List<Can> listaCans) {
		this.listaCans = listaCans;
	}

	public List<Caracter> getListaCaracteres() {
		return listaCaracteres;
	}

	public void setListaCaracteres(List<Caracter> listaCaracteres) {
		this.listaCaracteres = listaCaracteres;
	}

	public List<Raza> getListaRazas() {
		return listaRazas;
	}

	public void setListaRazas(List<Raza> listaRazas) {
		this.listaRazas = listaRazas;
	}

	public List<Dueno> getListaduenos() {
		return listaduenos;
	}

	public void setListaduenos(List<Dueno> listaduenos) {
		this.listaduenos = listaduenos;
	}

	public Caracter getCaracter() {
		return caracter;
	}

	public void setCaracter(Caracter caracter) {
		this.caracter = caracter;
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

	public Dueno getDueno() {
		return dueno;
	}

	public void setDueno(Dueno dueno) {
		this.dueno = dueno;
	}
	
}
