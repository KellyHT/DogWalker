package pe.dogwalker.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.dogwalker.model.entity.Calificacion;
import pe.dogwalker.service.CalificacionService;
import pe.dogwalker.util.Message;

@Named
@SessionScoped
public class CalificacionController implements Serializable {
///HOLAAAA
	/*
	private static final long serialVersionUID = 1L;

	@Inject
	private CalificacionService calificacionService;

	private Calificacion calificacion;
	private List<Calificacion> calificacions;
	private Calificacion calificacionSelect;

	private String filterName;

	@PostConstruct
	public void init() {
		calificacion = new Calificacion();
		calificacions = new ArrayList<Calificacion>();
		getAllCalificacions();
	}

	public void getAllCalificacions() {
		try {
			calificacions = calificacionService.findAll();
		} catch (Exception e) {
			Message.messageError("Error al cargar Calificacionos: " + e.getMessage());
		}
	}

	public String newCalificacion() {
		return "/calificacion/insert";
	}

	public void resetForm() {
		this.filterName = "";
		this.calificacion = new Calificacion();
	}

	public String listCalificacion() {
		return "/calificacion/list";
	}

	public String saveCalificacion() {
		String view = "";
		try {
			if (calificacion.getIdCalificacion() != null) {
				calificacionService.update(calificacion);
				Message.messageInfo("Registro Actualizado Correctamente");
			} else {
				calificacionService.insert(calificacion);
				Message.messageInfo("Registro Insertado Correctamente");
			}
			this.getAllCalificacions();
			resetForm();
			view = "/calificacion/list";
		} catch (Exception e) {
		}
		return view;
	}

	public String editCalificacion() {
		String view = "";
		try {
			if (this.calificacionSelect != null) {
				this.calificacion = calificacionSelect;
				view = "/calificacion/update";
			} else {
				Message.messageError("Debe Seleccionar un calificaciono");
			}
		} catch (Exception e) {
			Message.messageError("Error  en calificaciono: " + e.getMessage());
		}
		return view;
	}

	public String deleteCalificacion() {
		String view = "";
		try {
			this.calificacion = calificacionSelect;
			calificacionService.delete(this.calificacion);
			Message.messageInfo("Registro Eliminado Correctamente");
			this.getAllCalificacions();
			view = "/calificacion/list";
		} catch (Exception e) {
			Message.messageError("Error en calificaciono " + e.getMessage());
		}
		return view;
	}

	public void searchCalificacionByName() {
		try {
			calificacions = calificacionService.findByName(this.filterName.trim());
			resetForm();
			if (calificacions.isEmpty()) {
				Message.messageInfo("No se encontraron calificacionos");
			}
		} catch (Exception e) {
			Message.messageError("Error en calificaciono " + e.getMessage());
		}
	}

	public void calificacionSelect(SelectEvent e) {
		this.calificacionSelect = (Calificacion) e.getObject();
	}

*/
	
}
