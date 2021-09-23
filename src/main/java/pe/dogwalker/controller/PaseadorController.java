package pe.dogwalker.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.dogwalker.model.entity.Paseador;
import pe.dogwalker.model.entity.Distrito;
import pe.dogwalker.service.PaseadorService;
import pe.dogwalker.service.DistritoService;
import pe.dogwalker.util.Message;

@Named
@SessionScoped
public class PaseadorController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PaseadorService paseadorService;
	
	@Inject
	private DistritoService distritoService;
	
	private Paseador paseador;
	private List<Paseador> paseadors;
	private Paseador paseadorSelect;
	
	private Distrito distrito;
	private List<Distrito> distritos;
	
	private String filterName;
	
	@PostConstruct
	public void init() {
		paseador = new Paseador();
		distrito = new Distrito();
		paseadors = new ArrayList<Paseador>();
		distritos = new ArrayList<Distrito>();
		
		getAllPaseadors();
	}
	
	
	public void getAllPaseadors() {
		try {
			paseadors = paseadorService.findAll();
		} catch (Exception e) {
			Message.messageError("Error al cargar Paseadoros: " + e.getMessage());
		}
	}
	
	public String newPaseador() {
		try {
			this.distritos = distritoService.findAll();
			resetForm();
		} catch (Exception e) {
		}
		return "/paseador/insert";
	}
	
	public void resetForm() {
		this.filterName = "";
		this.paseador = new Paseador();
	}
	
	public String listPaseador() {
		return "/paseador/list";
	}
	
	public String savePaseador() {
		Message.messageInfo("ingresoooooo");	

		String view = "";
		try {
			if (paseador.getId() != null) 
			{
				paseador.setDistrito(distrito);
				paseadorService.update(paseador);
				Message.messageInfo("Registro Actualizado Correctamente");
			}
			else 
			{
				Message.messageInfo("ingresoooooo" +paseador.getId()+"   " );	
				System.out.println("Ingrese  " +paseador.getId());
				paseador.setDistrito(distrito);
				paseadorService.insert(paseador);
				Message.messageInfo("Registro Insertado Correctamente");				
			}
			this.getAllPaseadors();
			resetForm();
			view = "/paseador/list";
		} 
		catch (Exception e) {
		}
		return view;
	}
	
	public String editPaseador() {
		String view = "";
		try 
		{
			if (this.paseadorSelect != null) 
			{
				this.paseador = paseadorSelect;
				view = "/paseador/update";
			}
			else 
			{
				Message.messageError("Debe Seleccionar un paseadoro");
			}
		} 
		catch (Exception e) {
			Message.messageError("Error  en paseadoro: " + e.getMessage());
		}
		return view;
	}
	
	public String deletePaseador() {
		String view = "";
		try {
			this.paseador = paseadorSelect;
			paseadorService.delete(this.paseador);
			Message.messageInfo("Registro Eliminado Correctamente");
			this.getAllPaseadors();
			view = "/paseador/list";
		} catch (Exception e) {
			Message.messageError("Error en paseadoro " + e.getMessage());
		}
		return view;
	}
	
	public void searchPaseadorByName() {
		try {
			paseadors = paseadorService.findByName(this.filterName.trim());
			resetForm();
			if (paseadors.isEmpty()) {
				Message.messageInfo("No se encontraron paseadoros");
			}
		} catch (Exception e) {
			Message.messageError("Error en paseadoro " + e.getMessage());
		}
	}
	
	public void paseadorSelect(SelectEvent e) {
		this.paseadorSelect = (Paseador)e.getObject();
	}


	public Paseador getPaseador() {
		return paseador;
	}


	public void setPaseador(Paseador paseador) {
		this.paseador = paseador;
	}


	public List<Paseador> getPaseadors() {
		return paseadors;
	}


	public void setPaseadors(List<Paseador> paseadors) {
		this.paseadors = paseadors;
	}


	public Paseador getPaseadorSelect() {
		return paseadorSelect;
	}


	public void setPaseadorSelect(Paseador paseadorSelect) {
		this.paseadorSelect = paseadorSelect;
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
