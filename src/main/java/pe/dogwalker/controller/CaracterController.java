package pe.dogwalker.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped

public class CaracterController implements Serializable {

/*	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICaracterService cService;
	private Caracter caracter;
	List<Caracter> listaCaracters;
	
	@PostConstruct
	public void init() {
		this.listaCaracters = new ArrayList<Caracter>();
		this.caracter = new Caracter();
		this.listar();
	}

	public String nuevoCaracter() {
		this.setCaracter(new Caracter());
		return "caracter.xhtml";
	}
	
	public void insertar() {
		cService.insertar(caracter);
		limpiarCaracter();
	}
	
	public void listar() {
		listaCaracters = cService.listar();
	}

	public void limpiarCaracter() {
		this.init();
	}
	
	public void eliminar(Caracter caracter) {
		cService.eliminar(caracter.getIdCaracter());
		this.listar();
	}

	public Caracter getCaracter() {
		return caracter;
	}

	public void setCaracter(Caracter caracter) {
		this.caracter = caracter;
	}

	public List<Caracter> getListaCaracteres() {
		return listaCaracters;
	}

	public void setListaCaracteres(List<Caracter> listaCaracters) {
		this.listaCaracters = listaCaracters;
	}
	*/
}
