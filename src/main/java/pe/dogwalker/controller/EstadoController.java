package pe.dogwalker.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped

public class EstadoController implements Serializable {

/*	private static final long serialVersionUID = 1L;
	
	@Inject
	private IEstadoService eService;
	private Estado estado;
	List<Estado> listaEstados;
	
	@PostConstruct
	public void init() {
		this.listaEstados = new ArrayList<Estado>();
		this.estado = new Estado();
		this.listar();
	}

	public String nuevoEstado() {
		this.setEstado(new Estado());
		return "estado.xhtml";
	}
	
	public void insertar() {
		eService.insertar(estado);
		limpiarEstado();
	}
	
	public void listar() {
		listaEstados = eService.listar();
	}

	public void limpiarEstado() {
		this.init();
	}
	
	public void eliminar(Estado estado) {
		eService.eliminar(estado.getIdEstado());
		this.listar();
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getListaEstadoes() {
		return listaEstados;
	}

	public void setListaEstadoes(List<Estado> listaEstados) {
		this.listaEstados = listaEstados;
	}*/
	
}
