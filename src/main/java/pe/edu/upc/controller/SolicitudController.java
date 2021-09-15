package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Dueno;
import pe.edu.upc.entity.Estado;
import pe.edu.upc.entity.Paseador;
import pe.edu.upc.entity.Solicitud;
import pe.edu.upc.entity.Tiempo;
import pe.edu.upc.service.IDuenoService;
import pe.edu.upc.service.IEstadoService;
import pe.edu.upc.service.IPaseadorService;
import pe.edu.upc.service.ISolicitudService;
import pe.edu.upc.service.ITiempoService;

@Named
@RequestScoped

public class SolicitudController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ISolicitudService sService;
	@Inject
	private IEstadoService eService;
	@Inject
	private ITiempoService tService;
	@Inject
	private IDuenoService dService;
	@Inject
	private IPaseadorService pService;
	private Solicitud solicitud;
	private Estado estado;
	private Tiempo tiempo;
	private Dueno dueno;
	private Paseador paseador;
	List<Solicitud> listaSolicitudes;
	List<Estado> listaEstados;
	List<Tiempo> listaTiempos;
	List<Dueno> listaDuenos;
	List<Paseador> listaPaseadores;
	
	
	@PostConstruct
	public void init() {
		this.listaSolicitudes = new ArrayList<Solicitud>();
		this.listaEstados = new ArrayList<Estado>();
		this.listaTiempos = new ArrayList<Tiempo>();
		this.listaDuenos = new ArrayList<Dueno>();
		this.listaPaseadores = new ArrayList<Paseador>();
		this.solicitud = new Solicitud();
		this.estado = new Estado();
		this.tiempo = new Tiempo();
		this.dueno = new Dueno();
		this.paseador = new Paseador();
		this.listar();
		this.listarEstados();
		this.listarTiempo();
		this.listarDuenos();
		this.listarPaseadores();
		
		
	}

	public String nuevoSolicitud() {
		this.setSolicitud(new Solicitud());
		return "solicitud.xhtml";
	}
	
	public void insertar() {
		sService.insertar(solicitud);
		limpiarSolicitud();
	}
	
	public void listar() {
		listaSolicitudes = sService.listar();
	}

	public void listarEstados() {
		listaEstados = eService.listar();
	}

	public void listarTiempo() {
		listaTiempos = tService.listar();
	}

	public void listarDuenos() {
		listaDuenos = dService.listar();
	}

	public void listarPaseadores() {
		listaPaseadores = pService.listar();
	}

	public void limpiarSolicitud() {
		this.init();
	}
	
	public void eliminar(Solicitud solicitud) {
		sService.eliminar(solicitud.getIdSolicitud());
		this.listar();
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Tiempo getTiempo() {
		return tiempo;
	}

	public void setTiempo(Tiempo tiempo) {
		this.tiempo = tiempo;
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

	public List<Solicitud> getListaSolicitudes() {
		return listaSolicitudes;
	}

	public void setListaSolicitudes(List<Solicitud> listaSolicitudes) {
		this.listaSolicitudes = listaSolicitudes;
	}

	public List<Estado> getListaEstados() {
		return listaEstados;
	}

	public void setListaEstados(List<Estado> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public List<Tiempo> getListaTiempos() {
		return listaTiempos;
	}

	public void setListaTiempos(List<Tiempo> listaTiempos) {
		this.listaTiempos = listaTiempos;
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
