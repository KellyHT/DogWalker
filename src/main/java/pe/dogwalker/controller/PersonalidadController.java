package pe.dogwalker.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped

public class PersonalidadController implements Serializable {

/*	private static final long serialVersionUID = 1L;
	

	@Inject
	private IPersonalidadService peService;
	private Personalidad personalidad;
	private 
	List<Personalidad> listaPersonalidades;
	
	@PostConstruct
	public void init() {
		this.listaPersonalidades = new ArrayList<Personalidad>();
		this.personalidad = new Personalidad();
		this.listar();
	}

	public String nuevoPersonalidad() {
		this.setPersonalidad(new Personalidad());
		return "personalidad.xhtml";
		
	}
	
	public void insertar() {
		peService.insertar(personalidad);
		limpiarPersonalidad();
		this.listar();
	}
	
	public void listar() {
		listaPersonalidades = peService.listar();
	}

	public void limpiarPersonalidad() {
		this.init();
	}
	
	public void eliminar(Personalidad personalidad) {
		peService.eliminar(personalidad.getIdPersonalidad());
		this.listar();
	}

	public IPersonalidadService getPeService() {
		return peService;
	}

	public void setPeService(IPersonalidadService peService) {
		this.peService = peService;
	}

	public Personalidad getPersonalidad() {
		return personalidad;
	}

	public void setPersonalidad(Personalidad personalidad) {
		this.personalidad = personalidad;
	}

	public List<Personalidad> getListaPersonalidades() {
		return listaPersonalidades;
	}

	public void setListaPersonalidades(List<Personalidad> listaPersonalidades) {
		this.listaPersonalidades = listaPersonalidades;
	}

*/
	
}
