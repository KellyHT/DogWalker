package pe.dogwalker.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped

public class DetalleSolicitudController implements Serializable {

/*	private static final long serialVersionUID = 1L;
	
	@Inject
	private IDetalleSolicitudService dsService;
	@Inject
	private ICanService caService;
	@Inject
	private ISolicitudService sService;
	
	private DetalleSolicitud detalleSolicitud;
	private Can can;
	private Solicitud solicitud;
	
	List<DetalleSolicitud> listaDetalleSolicitudes;
	List<Can> listaCanes;
	List<Solicitud> listaSolicitudes;
	
	@PostConstruct
	public void init() {
		this.listaDetalleSolicitudes = new ArrayList<DetalleSolicitud>();
		this.listaCanes = new ArrayList<Can>();
		this.listaSolicitudes = new ArrayList<Solicitud>();
		this.detalleSolicitud = new DetalleSolicitud();
		this.can = new Can();
		this.solicitud = new Solicitud();
		this.listar();
		this.listarCanes();
		this.listarSolicitudes();
	}

	public String nuevoDetalleSolicitud() {
		this.setDetalleSolicitud(new DetalleSolicitud());
		return "detalleSolicitud.xhtml";
	}
	
	public void insertar() {
		dsService.insertar(detalleSolicitud);
		limpiarDetalleSolicitud();
	}
	
	public void listar() {
		listaDetalleSolicitudes = dsService.listar();
	}
	public void listarCanes() {
		listaCanes = caService.listar();
	}
	public void listarSolicitudes() {
		listaSolicitudes = sService.listar();
	}

	public void limpiarDetalleSolicitud() {
		this.init();
	}
	
	public void eliminar(DetalleSolicitud detalleSolicitud) {
		dsService.eliminar(detalleSolicitud.getIdDetalle());
		this.listar();
	}

	public DetalleSolicitud getDetalleSolicitud() {
		return detalleSolicitud;
	}

	public void setDetalleSolicitud(DetalleSolicitud detalleSolicitud) {
		this.detalleSolicitud = detalleSolicitud;
	}

	public Can getCan() {
		return can;
	}

	public void setCan(Can can) {
		this.can = can;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public List<DetalleSolicitud> getListaDetalleSolicitudes() {
		return listaDetalleSolicitudes;
	}

	public void setListaDetalleSolicitudes(List<DetalleSolicitud> listaDetalleSolicitudes) {
		this.listaDetalleSolicitudes = listaDetalleSolicitudes;
	}

	public List<Can> getListaCanes() {
		return listaCanes;
	}

	public void setListaCanes(List<Can> listaCanes) {
		this.listaCanes = listaCanes;
	}

	public List<Solicitud> getListaSolicitudes() {
		return listaSolicitudes;
	}

	public void setListaSolicitudes(List<Solicitud> listaSolicitudes) {
		this.listaSolicitudes = listaSolicitudes;
	}

*/
	
}
