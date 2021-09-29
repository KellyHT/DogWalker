package pe.dogwalker.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.dogwalker.model.entity.Dueno;
import pe.dogwalker.model.entity.Paseador;
import pe.dogwalker.model.entity.Solicitud;
import pe.dogwalker.model.entity.Tiempo;
import pe.dogwalker.service.DuenoService;
import pe.dogwalker.service.PaseadorService;
import pe.dogwalker.service.SolicitudService;
import pe.dogwalker.service.TiempoService;
import pe.dogwalker.util.Message;

@Named
@SessionScoped
public class SolicitudController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private SolicitudService solicitudService;
	
	@Inject
	private DuenoService duenoService;
	
	@Inject
	private PaseadorService paseadorService;
	
	@Inject
	private TiempoService tiempoService;
	
	
	private Solicitud solicitud;
	private List<Solicitud> solicitudes;
	private Solicitud solicitudSelect;
	
	private Dueno dueno;
	private List<Dueno> duenos;
	
	
	private Paseador paseador;
	private List<Paseador> paseadores;
	
	private Tiempo tiempo;
	private List<Tiempo> tiempos;
	
	
	private String filterName;
	
	@PostConstruct
	public void init() {
		solicitud = new Solicitud();
		dueno = new Dueno();
		paseador = new Paseador();
		tiempo = new Tiempo();
		solicitudes = new ArrayList<Solicitud>();
		duenos = new ArrayList<Dueno>();
		paseadores = new ArrayList<Paseador>();
		tiempos = new ArrayList<Tiempo>();
		getAllSolicituds();
	}
	
	
	public void getAllSolicituds() {
		try {
			solicitudes = solicitudService.findAll();
		} catch (Exception e) {
			Message.messageError("Error al cargar Solicitudos: " + e.getMessage());
		}
	}
	
	public String newSolicitud() {
		try {
			this.duenos = duenoService.findAll();
			this.paseadores = paseadorService.findAll();
			this.tiempos = tiempoService.findAll();
			resetForm();
		} catch (Exception e) {
		}
		return "/solicitud/registrarCuentaSolicitud";
	}
	
	public void resetForm() {
		this.filterName = "";
		this.solicitud = new Solicitud();
	}
	
	public String listSolicitud() {
		return "/solicitud/list";
	}
	
	public String saveSolicitud() {

		String view = "";
		try {
			if (solicitud.getIdSolicitud() != null) 
			{
				solicitud.setDueno(dueno);
				solicitud.setPaseador(paseador);
				solicitud.setTiempo(tiempo);
				solicitudService.update(solicitud);
				Message.messageInfo("Calificación actualizada");
			}
			else 
			{
				solicitud.setDueno(dueno);
				solicitud.setPaseador(paseador);
				solicitud.setTiempo(tiempo);
				solicitudService.insert(solicitud);
				Message.messageInfo("Calificación registrada");				
			}
			this.getAllSolicituds();
			resetForm();
			view = "/solicitud/list";
		} 
		catch (Exception e) {
		}
		return view;
	}
	
	public String editSolicitud() {
		String view = "";
		try 
		{
			if (this.solicitudSelect != null) 
			{
				this.solicitud = solicitudSelect;
				view = "/solicitud/update";
			}
			else 
			{
				Message.messageError("Debe Seleccionar un solicitudo");
			}
		} 
		catch (Exception e) {
			Message.messageError("Error  en dueño: " + e.getMessage());
		}
		return view;
	}
	
	public String deleteSolicitud() {
		String view = "";
		try {
			this.solicitud = solicitudSelect;
			solicitudService.delete(this.solicitud);
			Message.messageInfo("Registro Eliminado Correctamente");
			this.getAllSolicituds();
			view = "/solicitud/list";
		} catch (Exception e) {
			Message.messageError("Error en solicitudo " + e.getMessage());
		}
		return view;
	}
	
	public void searchSolicitudByName() {
		try {
			solicitudes = solicitudService.findByName(this.filterName.trim());
			resetForm();
			if (solicitudes.isEmpty()) {
				Message.messageInfo("No se encontraron solicitudos");
			}
		} catch (Exception e) {
			Message.messageError("Error en solicitudo " + e.getMessage());
		}
	}


	public TiempoService getTiempoService() {
		return tiempoService;
	}


	public void setTiempoService(TiempoService tiempoService) {
		this.tiempoService = tiempoService;
	}


	public Solicitud getSolicitud() {
		return solicitud;
	}


	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}


	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}


	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}


	public Solicitud getSolicitudSelect() {
		return solicitudSelect;
	}


	public void setSolicitudSelect(Solicitud solicitudSelect) {
		this.solicitudSelect = solicitudSelect;
	}


	public Dueno getDueno() {
		return dueno;
	}


	public void setDueno(Dueno dueno) {
		this.dueno = dueno;
	}


	public List<Dueno> getDuenos() {
		return duenos;
	}


	public void setDuenos(List<Dueno> duenos) {
		this.duenos = duenos;
	}


	public Paseador getPaseador() {
		return paseador;
	}


	public void setPaseador(Paseador paseador) {
		this.paseador = paseador;
	}


	public List<Paseador> getPaseadores() {
		return paseadores;
	}


	public void setPaseadores(List<Paseador> paseadores) {
		this.paseadores = paseadores;
	}


	public Tiempo getTiempo() {
		return tiempo;
	}


	public void setTiempo(Tiempo tiempo) {
		this.tiempo = tiempo;
	}


	public List<Tiempo> getTiempos() {
		return tiempos;
	}


	public void setTiempos(List<Tiempo> tiempos) {
		this.tiempos = tiempos;
	}


	public String getFilterName() {
		return filterName;
	}


	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}


	
}
