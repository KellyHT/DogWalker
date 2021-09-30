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
import pe.dogwalker.model.entity.Personalidad;
import pe.dogwalker.model.entity.Distrito;
import pe.dogwalker.service.PaseadorService;
import pe.dogwalker.service.PersonalidadService;
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
	
	@Inject
	private PersonalidadService personalidadService;
	
	private Paseador paseador;
	private List<Paseador> paseadores;
	private Paseador paseadorSelect;
	
	private Distrito distrito;
	private List<Distrito> distritos;
	
	private Personalidad personalidad;
	private List<Personalidad> personalidades;
	
	private String filterName;
	private String filterNombreDistrito;
	
	private String correo;
	private String contrasena;
	
	@PostConstruct
	public void init() {
		paseador = new Paseador();
		distrito = new Distrito();
		personalidad= new Personalidad();
		paseadores = new ArrayList<Paseador>();
		distritos = new ArrayList<Distrito>();
		personalidades = new ArrayList<Personalidad>();
		
		getAllPaseadors();
	}
	
	
	public void getAllPaseadors() {
		try {
			paseadores = paseadorService.findAll();
		} catch (Exception e) {
			Message.messageError("Error al cargar Paseadoros: " + e.getMessage());
		}
	}
	
	public String newPaseador() {
		try {
			this.distritos = distritoService.findAll();
			this.personalidades= personalidadService.findAll();
			resetForm();
		} catch (Exception e) {
		}
		return "/registrarCuentaPaseador";
	}
	
	public void resetForm() {
		this.filterName = "";
		this.filterNombreDistrito = "";
		this.paseador = new Paseador();
	}
	

	public String savePaseador() {

		String view = "";
		try {
			if (paseador.getId() != null) 
			{
				paseador.setDistrito(distrito);
				paseador.setPersonalidad(personalidad);
				paseadorService.update(paseador);
				Message.messageInfo("Registro Actualizado Correctamente");
				view = "menuPaseador";
			}
			else 
			{
				paseador.setDistrito(distrito);
				paseador.setPersonalidad(personalidad);
				paseadorService.insert(paseador);
				Message.messageInfo("Registro Insertado Correctamente");
				view = "inicioPaseador.xhtml";
			}
			this.getAllPaseadors();
			resetForm();
			
		} 
		catch (Exception e) {
		}
		return view;
	}
	
	public String editPaseador() {
		String view ="";
		try {
			this.distritos = distritoService.findAll();
			this.personalidades= personalidadService.findAll();
			
			 view = "/editarCuentaPaseador";
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
			return view ;
			
	}
	

	
	public void searchPaseadorByName() {
		try {
			paseadores = paseadorService.findByName(this.filterName.trim());
			resetForm();
			if (paseadores.isEmpty()) {
				Message.messageInfo("No se encontraron paseadoros");
			}
		} catch (Exception e) {
			Message.messageError("Error en paseadoro " + e.getMessage());
		}
	}
	
	public String searchPaseadorByNombreDistrito() {
		String view ="";
		try {
			
			paseadores = paseadorService.findByDistrito(this.filterNombreDistrito.trim());
			resetForm();
			if (paseadores.isEmpty()) {
				 
			}
			else {
				view = "/listapaseador";
			}
		} catch (Exception e) {
			Message.messageError("Error en paseadoro " + e.getMessage());
			 
		}
		return view;
	}
	
	
	public String verificarUsuario() {
		String view ="";
		try {
			paseadores = paseadorService.findByCorreoContrasena(this.correo, this.contrasena);
			resetForm();
			if (paseadores.isEmpty()) {
				view = "ingresarCuentaPaseador.xhtml";
				
			
			}else {
				this.paseador = paseadores.get(0);
				Message.messageInfo("Se ha iniciado sesión como Dueño");
				view = "inicioPaseador.xhtml";
			}
		} catch (Exception e) {
			Message.messageError("Error " + e.getMessage());
		}
		return view;
	}
	
	public String solicitudPaseador(){
		
		return "/GestionarSolicitudesPaseador";
	}
	
	
public String menuPaseador(){
		
		return "/menuPaseador";
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
		return paseadores;
	}


	public void setPaseadors(List<Paseador> paseadores) {
		this.paseadores = paseadores;
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


	public PaseadorService getPaseadorService() {
		return paseadorService;
	}


	public void setPaseadorService(PaseadorService paseadorService) {
		this.paseadorService = paseadorService;
	}


	public DistritoService getDistritoService() {
		return distritoService;
	}


	public void setDistritoService(DistritoService distritoService) {
		this.distritoService = distritoService;
	}


	public PersonalidadService getPersonalidadService() {
		return personalidadService;
	}


	public void setPersonalidadService(PersonalidadService personalidadService) {
		this.personalidadService = personalidadService;
	}


	public Personalidad getPersonalidad() {
		return personalidad;
	}


	public void setPersonalidad(Personalidad personalidad) {
		this.personalidad = personalidad;
	}


	public List<Personalidad> getPersonalidades() {
		return personalidades;
	}


	public void setPersonalidades(List<Personalidad> personalidades) {
		this.personalidades = personalidades;
	}


	public List<Paseador> getPaseadores() {
		return paseadores;
	}


	public void setPaseadores(List<Paseador> paseadores) {
		this.paseadores = paseadores;
	}


	public String getFilterNombreDistrito() {
		return filterNombreDistrito;
	}


	public void setFilterNombreDistrito(String filterNombreDistrito) {
		this.filterNombreDistrito = filterNombreDistrito;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	

}
