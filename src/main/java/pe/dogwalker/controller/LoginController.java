package pe.dogwalker.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.dogwalker.model.entity.Dueno;
import pe.dogwalker.model.entity.Paseador;
import pe.dogwalker.service.DuenoService;
import pe.dogwalker.service.PaseadorService;

@Named
@SessionScoped
public class LoginController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DuenoService duenoService;
	
	@Inject
	private PaseadorService paseadorService;
	
	private Dueno dueno;
	private Paseador paseador;
	
	
	@PostConstruct
	public void init() {
		dueno = new Dueno();
		paseador = new Paseador();
	}
	
	/*
	public void verificarUsuario() {
		try {
			logins = loginService.findByName(this.filterName.trim());
			resetForm();
			if (logins.isEmpty()) {
				Message.messageInfo("No se encontraron loginos");
			}
		} catch (Exception e) {
			Message.messageError("Error en logino " + e.getMessage());
		}
	}
	*/

	
	
}
