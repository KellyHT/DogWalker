package pe.dogwalker.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.dogwalker.model.entity.Dueno;
import pe.dogwalker.model.entity.Distrito;
import pe.dogwalker.service.DuenoService;
import pe.dogwalker.service.DistritoService;
import pe.dogwalker.util.Message;

@Named
@SessionScoped
public class DuenoController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DuenoService duenoService;
	
	@Inject
	private DistritoService distritoService;
	
	private Dueno dueno;
	private List<Dueno> duenos;
	private Dueno duenoSelect;
	
	private Distrito distrito;
	private List<Distrito> distritos;
	
	private String filterName;
	
	@PostConstruct
	public void init() {
		dueno = new Dueno();
		distrito = new Distrito();
		duenos = new ArrayList<Dueno>();
		distritos = new ArrayList<Distrito>();
		
		getAllDuenos();
	}
	
	
	public void getAllDuenos() {
		try {
			duenos = duenoService.findAll();
		} catch (Exception e) {
			Message.messageError("Error al cargar Duenoos: " + e.getMessage());
		}
	}
	
	public String newDueno() {
		try {
			this.distritos = distritoService.findAll();
			resetForm();
		} catch (Exception e) {
		}
		return "/dueno/registrarCuentaDueno";
	}
	
	public void resetForm() {
		this.filterName = "";
		this.dueno = new Dueno();
	}
	
	public String listDueno() {
		return "/dueno/list";
	}
	
	public String saveDueno() {

		String view = "";
		try {
			if (dueno.getId() != null) 
			{
				dueno.setDistrito(distrito);
				duenoService.update(dueno);
				Message.messageInfo("Registro Actualizado Correctamente");
			}
			else 
			{
				dueno.setDistrito(distrito);
				duenoService.insert(dueno);
				Message.messageInfo("Registro Insertado Correctamente");				
			}
			this.getAllDuenos();
			resetForm();
			view = "/dueno/list";
		} 
		catch (Exception e) {
		}
		return view;
	}
	
	public String editDueno() {
		String view = "";
		try 
		{
			if (this.duenoSelect != null) 
			{
				this.dueno = duenoSelect;
				view = "/dueno/update";
			}
			else 
			{
				Message.messageError("Debe Seleccionar un duenoo");
			}
		} 
		catch (Exception e) {
			Message.messageError("Error  en dueño: " + e.getMessage());
		}
		return view;
	}
	
	public String deleteDueno() {
		String view = "";
		try {
			this.dueno = duenoSelect;
			duenoService.delete(this.dueno);
			Message.messageInfo("Registro Eliminado Correctamente");
			this.getAllDuenos();
			view = "/dueno/list";
		} catch (Exception e) {
			Message.messageError("Error en duenoo " + e.getMessage());
		}
		return view;
	}
	
	public void searchDuenoByName() {
		try {
			duenos = duenoService.findByName(this.filterName.trim());
			resetForm();
			if (duenos.isEmpty()) {
				Message.messageInfo("No se encontraron duenoos");
			}
		} catch (Exception e) {
			Message.messageError("Error en duenoo " + e.getMessage());
		}
	}
	
	public void duenoSelect(SelectEvent e) {
		this.duenoSelect = (Dueno)e.getObject();
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


	public Dueno getDuenoSelect() {
		return duenoSelect;
	}


	public void setDuenoSelect(Dueno duenoSelect) {
		this.duenoSelect = duenoSelect;
	}


	public Distrito getDistrito() {
		return distrito;
	}


	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}


	public List<Distrito> getDistritos() {
		return distritos;
	}


	public void setDistritos(List<Distrito> distritos) {
		this.distritos = distritos;
	}


	public String getFilterName() {
		return filterName;
	}


	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

}
