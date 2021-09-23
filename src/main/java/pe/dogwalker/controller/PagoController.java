package pe.dogwalker.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped

public class PagoController implements Serializable {

/*	private static final long serialVersionUID = 1L;
	
	@Inject
	private IPagoService pService;
	@Inject
	private ISolicitudService sService;
	@Inject
	private ITarjetaService tService;
	private Pago pago;
	private Solicitud solicitud;
	private Tarjeta tarjeta;
	List<Pago> listaPagos;
	List<Solicitud> listaSolicitudes;
	List<Tarjeta> listaTarjetas;
	
	@PostConstruct
	public void init() {
		this.listaPagos = new ArrayList<Pago>();
		this.listaSolicitudes = new ArrayList<Solicitud>();
		this.listaTarjetas = new ArrayList<Tarjeta>();
		this.pago = new Pago();
		this.solicitud = new Solicitud();
		this.tarjeta = new Tarjeta();
		this.listar();
		this.listarSolicitudes();
		this.listarTarjetas();
	}

	public String nuevoPago() {
		this.setPago(new Pago());
		return "pago.xhtml";
	}
	
	public void insertar() {
		pService.insertar(pago);
		limpiarPago();
	}
	
	public void listar() {
		listaPagos = pService.listar();
	}
	public void listarSolicitudes() {
		listaSolicitudes = sService.listar();
	}
	public void listarTarjetas() {
		listaTarjetas = tService.listar();
	}

	public void limpiarPago() {
		this.init();
	}
	
	public void eliminar(Pago pago) {
		pService.eliminar(pago.getIdPago());
		this.listar();
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public List<Pago> getListaPagos() {
		return listaPagos;
	}

	public void setListaPagos(List<Pago> listaPagos) {
		this.listaPagos = listaPagos;
	}

	public List<Solicitud> getListaSolicitudes() {
		return listaSolicitudes;
	}

	public void setListaSolicitudes(List<Solicitud> listaSolicitudes) {
		this.listaSolicitudes = listaSolicitudes;
	}

	public List<Tarjeta> getListaTarjetas() {
		return listaTarjetas;
	}

	public void setListaTarjetas(List<Tarjeta> listaTarjetas) {
		this.listaTarjetas = listaTarjetas;
	}

*/
	
}
