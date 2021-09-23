package pe.dogwalker.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.dogwalker.model.entity.Can;
import pe.dogwalker.model.entity.Raza;
import pe.dogwalker.service.CanService;
import pe.dogwalker.service.RazaService;
import pe.dogwalker.util.Message;

@Named
@SessionScoped
public class CanController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CanService canService;
	
	@Inject
	private RazaService razaService;
	
	private Can can;
	private List<Can> cans;
	private Can canSelect;
	
	private Raza raza;
	private List<Raza> razas;
	
	private String filterName;
	
	@PostConstruct
	public void init() {
		can = new Can();
		raza = new Raza();
		cans = new ArrayList<Can>();
		razas = new ArrayList<Raza>();
		
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
			this.razas = razaService.findAll();
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
				Message.messageInfo("Ingresseeee update");
				can.setRaza(raza);
				canService.update(can);
				Message.messageInfo("Registro Actualizado Correctamente");
			}
			else 
			{
				can.setRaza(raza);
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
			Message.messageError("Error  en dueño: " + e.getMessage());
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


	public Raza getRaza() {
		return raza;
	}


	public void setRaza(Raza raza) {
		this.raza = raza;
	}


	public List<Raza> getRazas() {
		return razas;
	}


	public void setRazas(List<Raza> razas) {
		this.razas = razas;
	}


	public String getFilterName() {
		return filterName;
	}


	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

}
