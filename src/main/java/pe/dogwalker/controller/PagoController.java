package pe.dogwalker.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.dogwalker.model.entity.Pago;
import pe.dogwalker.model.entity.Tarjeta;
import pe.dogwalker.service.PagoService;
import pe.dogwalker.service.TarjetaService;
import pe.dogwalker.util.Message;

@Named
@SessionScoped
public class PagoController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PagoService pagoService;
	
	@Inject
	private TarjetaService tarjetaService;
	
	private Pago pago;
	private List<Pago> pagos;
	private Pago pagoSelect;
	
	private Tarjeta tarjeta;
	private List<Tarjeta> tarjetas;
	
	private String filterName;
	
	@PostConstruct
	public void init() {
		pago = new Pago();
		tarjeta = new Tarjeta();
		pagos = new ArrayList<Pago>();
		tarjetas = new ArrayList<Tarjeta>();
		
		getAllPagos();
	}
	
	
	public void getAllPagos() {
		try {
			pagos = pagoService.findAll();
		} catch (Exception e) {
			Message.messageError("Error al cargar Pagoos: " + e.getMessage());
		}
	}
	
	public String newPago() {
		try {
			this.tarjetas = tarjetaService.findAll();
			resetForm();
		} catch (Exception e) {
		}
		return "/pago/registrarCuentaPago";
	}
	
	public void resetForm() {
		this.filterName = "";
		this.pago = new Pago();
	}
	
	public String listPago() {
		return "/pago/list";
	}
	
	public String savePago() {

		String view = "";
		try {
			if (pago.getIdPago() != null) 
			{
				pago.setTarjeta(tarjeta);
				pagoService.update(pago);
				Message.messageInfo("Registro Actualizado Correctamente");
			}
			else 
			{
				pago.setTarjeta(tarjeta);
				pagoService.insert(pago);
				Message.messageInfo("Registro Insertado Correctamente");				
			}
			this.getAllPagos();
			resetForm();
			view = "/pago/list";
		} 
		catch (Exception e) {
		}
		return view;
	}
	
	public String editPago() {
		String view = "";
		try 
		{
			if (this.pagoSelect != null) 
			{
				this.pago = pagoSelect;
				view = "/pago/update";
			}
			else 
			{
				Message.messageError("Debe Seleccionar un pagoo");
			}
		} 
		catch (Exception e) {
			Message.messageError("Error  en dueño: " + e.getMessage());
		}
		return view;
	}
	
	public String deletePago() {
		String view = "";
		try {
			this.pago = pagoSelect;
			pagoService.delete(this.pago);
			Message.messageInfo("Registro Eliminado Correctamente");
			this.getAllPagos();
			view = "/pago/list";
		} catch (Exception e) {
			Message.messageError("Error en pagoo " + e.getMessage());
		}
		return view;
	}
	
	public void searchPagoByName() {
		try {
			pagos = pagoService.findByName(this.filterName.trim());
			resetForm();
			if (pagos.isEmpty()) {
				Message.messageInfo("No se encontraron pagoos");
			}
		} catch (Exception e) {
			Message.messageError("Error en pagoo " + e.getMessage());
		}
	}
	

	
	public void pagoSelect(SelectEvent e) {
		this.pagoSelect = (Pago)e.getObject();
	}


	public Pago getPago() {
		return pago;
	}


	public void setPago(Pago pago) {
		this.pago = pago;
	}


	public List<Pago> getPagos() {
		return pagos;
	}


	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}


	public Pago getPagoSelect() {
		return pagoSelect;
	}


	public void setPagoSelect(Pago pagoSelect) {
		this.pagoSelect = pagoSelect;
	}


	public Tarjeta getTarjeta() {
		return tarjeta;
	}


	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}


	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}


	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}


	public String getFilterName() {
		return filterName;
	}


	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	
}
