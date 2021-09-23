package pe.dogwalker.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.dogwalker.model.entity.Can;
import pe.dogwalker.model.entity.Dueno;
import pe.dogwalker.service.CanService;
import pe.dogwalker.service.DuenoService;
import pe.dogwalker.util.Message;



@Named
@RequestScoped

public class CanController implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Inject
	private CanService canService;
	
	@Inject
	private DuenoService duenoService;
	
	private Can can;
	private List<Can> cans;
	private Can canSelect;
	
	private Dueno dueno;
	private List<Dueno> duenos;
	
	private String filterName;
	
	@PostConstruct
	public void init() {
		can = new Can();
		dueno = new Dueno();
		cans = new ArrayList<Can>();
		duenos = new ArrayList<Dueno>();
		
		getAllCans();
	}
	
	
	public void getAllCans() {
		try {
			cans = canService.findAll();
		} catch (Exception e) {
			Message.messageError("Error al cargar Canos: " + e.getMessage());
		}
	}
	
	public String newCan() {
		try {
			this.duenos = duenoService.findAll();
			resetForm();
		} catch (Exception e) {
		}
		return "/can/insert";
	}
	
	public void resetForm() {
		this.filterName = "";
		this.can = new Can();
	}
	
	public String listCan() {
		return "/can/list";
	}
	
	public String saveCan() {
		String view = "";
		try {
			if (can.getIdCan() != null) 
			{
				can.setDueno(dueno);
				canService.update(can);
				Message.messageInfo("Registro Actualizado Correctamente");
			}
			else 
			{
				can.setDueno(dueno);
				canService.insert(can);
				Message.messageInfo("Registro Insertado Correctamente");				
			}
			this.getAllCans();
			resetForm();
			view = "/can/list";
		} 
		catch (Exception e) {
		}
		return view;
	}
	
	public String editCan() {
		String view = "";
		try 
		{
			if (this.canSelect != null) 
			{
				this.can = canSelect;
				view = "/can/update";
			}
			else 
			{
				Message.messageError("Debe Seleccionar un cano");
			}
		} 
		catch (Exception e) {
			Message.messageError("Error  en cano: " + e.getMessage());
		}
		return view;
	}
	
	public String deleteCan() {
		String view = "";
		try {
			this.can = canSelect;
			canService.delete(this.can);
			Message.messageInfo("Registro Eliminado Correctamente");
			this.getAllCans();
			view = "/can/list";
		} catch (Exception e) {
			Message.messageError("Error en cano " + e.getMessage());
		}
		return view;
	}
	
	public void searchCanByName() {
		try {
			cans = canService.findByName(this.filterName.trim());
			resetForm();
			if (cans.isEmpty()) {
				Message.messageInfo("No se encontraron canos");
			}
		} catch (Exception e) {
			Message.messageError("Error en cano " + e.getMessage());
		}
	}
	
	public void canSelect(SelectEvent e) {
		this.canSelect = (Can)e.getObject();
	}


	public Can getCan() {
		return can;
	}


	public void setCan(Can can) {
		this.can = can;
	}


	public List<Can> getCans() {
		return cans;
	}


	public void setCans(List<Can> cans) {
		this.cans = cans;
	}


	public Can getCanSelect() {
		return canSelect;
	}


	public void setCanSelect(Can canSelect) {
		this.canSelect = canSelect;
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


	public String getFilterName() {
		return filterName;
	}


	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

}
