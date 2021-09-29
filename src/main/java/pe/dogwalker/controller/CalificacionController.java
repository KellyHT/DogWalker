package pe.dogwalker.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.dogwalker.model.entity.Calificacion;
import pe.dogwalker.model.entity.Dueno;
import pe.dogwalker.model.entity.Paseador;
import pe.dogwalker.service.CalificacionService;
import pe.dogwalker.service.DuenoService;
import pe.dogwalker.service.PaseadorService;
import pe.dogwalker.util.Message;

@Named
@SessionScoped
public class CalificacionController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CalificacionService calificacionService;
	
	@Inject
	private DuenoService duenoService;
	
	@Inject
	private PaseadorService paseadorService;
	
	private Calificacion calificacion;
	private List<Calificacion> calificacions;
	private Calificacion calificacionSelect;
	
	private Dueno dueno;
	private List<Dueno> duenos;
	
	
	private Paseador paseador;
	private List<Paseador> paseadores;
	
	
	private String filterName;
	
	@PostConstruct
	public void init() {
		calificacion = new Calificacion();
		dueno = new Dueno();
		paseador = new Paseador();
		calificacions = new ArrayList<Calificacion>();
		duenos = new ArrayList<Dueno>();
		paseadores = new ArrayList<Paseador>();
		
		getAllCalificacions();
	}
	
	
	public void getAllCalificacions() {
		try {
			calificacions = calificacionService.findAll();
		} catch (Exception e) {
			Message.messageError("Error al cargar Calificacionos: " + e.getMessage());
		}
	}
	
	public String newCalificacion() {
		try {
			this.duenos = duenoService.findAll();
			this.paseadores = paseadorService.findAll();
			resetForm();
		} catch (Exception e) {
		}
		return "/calificacion/registrarCuentaCalificacion";
	}
	
	public void resetForm() {
		this.filterName = "";
		this.calificacion = new Calificacion();
	}
	
	public String listCalificacion() {
		return "/calificacion/list";
	}
	
	public String saveCalificacion() {

		String view = "";
		try {
			if (calificacion.getIdCalificacion() != null) 
			{
				calificacion.setDueno(dueno);
				calificacion.setPaseador(paseador);
				calificacionService.update(calificacion);
				Message.messageInfo("Calificación actualizada");
			}
			else 
			{
				calificacion.setDueno(dueno);
				calificacion.setPaseador(paseador);
				calificacionService.insert(calificacion);
				Message.messageInfo("Calificación registrada");				
			}
			this.getAllCalificacions();
			resetForm();
			view = "/calificacion/list";
		} 
		catch (Exception e) {
		}
		return view;
	}
	
	public String editCalificacion() {
		String view = "";
		try 
		{
			if (this.calificacionSelect != null) 
			{
				this.calificacion = calificacionSelect;
				view = "/calificacion/update";
			}
			else 
			{
				Message.messageError("Debe Seleccionar una calificacion");
			}
		} 
		catch (Exception e) {
			Message.messageError("Error: " + e.getMessage());
		}
		return view;
	}
	
	public String deleteCalificacion() {
		String view = "";
		try {
			this.calificacion = calificacionSelect;
			calificacionService.delete(this.calificacion);
			Message.messageInfo("Registro Eliminado Correctamente");
			this.getAllCalificacions();
			view = "/calificacion/list";
		} catch (Exception e) {
			Message.messageError("Error en calificaciono " + e.getMessage());
		}
		return view;
	}
	
	public void searchCalificacionByName() {
		try {
			calificacions = calificacionService.findByName(this.filterName.trim());
			resetForm();
			if (calificacions.isEmpty()) {
				Message.messageInfo("No se encontraron calificacionos");
			}
		} catch (Exception e) {
			Message.messageError("Error en calificaciono " + e.getMessage());
		}
	}


	public Calificacion getCalificacion() {
		return calificacion;
	}


	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}


	public List<Calificacion> getCalificacions() {
		return calificacions;
	}


	public void setCalificacions(List<Calificacion> calificacions) {
		this.calificacions = calificacions;
	}


	public Calificacion getCalificacionSelect() {
		return calificacionSelect;
	}


	public void setCalificacionSelect(Calificacion calificacionSelect) {
		this.calificacionSelect = calificacionSelect;
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


	public String getFilterName() {
		return filterName;
	}


	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}
	

	


	
}
