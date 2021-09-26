package pe.dogwalker.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.dogwalker.model.entity.Dueno;
import pe.dogwalker.model.entity.Paseador;
import pe.dogwalker.service.DuenoService;
import pe.dogwalker.service.PaseadorService;
import pe.dogwalker.util.Message;

@Named
@SessionScoped
public class LoginController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DuenoService duenoService;
	
	@Inject
	private PaseadorService paseadorService;
	
	
	private Dueno dueno;
	private List<Dueno> duenos;
	private Paseador paseador;
	private List<Paseador> paseadores;
	
	private String correo;
	private String contrasena;
	
	
	@PostConstruct
	public void init() {
		dueno = new Dueno();
		paseador = new Paseador();
	}
	
	public void resetForm() {
		this.dueno = new Dueno();
	}
	public void verificarUsuario() {
		System.out.print("verificar cuenta");
		String view = "";
		try {
			duenos = duenoService.findByCorreoContrasena(this.dueno.getCorreo().trim().toString(),this.dueno.getContrasena().trim().toString());
			Message.messageInfo("Inicio de sesión exitoso");
			//view = "/dueno/list";
			resetForm();
			
		} catch (Exception e) {
			Message.messageError("No se puede iniciar sesión " + e.getMessage());
			resetForm();
		}
	}

	public DuenoService getDuenoService() {
		return duenoService;
	}

	public void setDuenoService(DuenoService duenoService) {
		this.duenoService = duenoService;
	}

	public PaseadorService getPaseadorService() {
		return paseadorService;
	}

	public void setPaseadorService(PaseadorService paseadorService) {
		this.paseadorService = paseadorService;
	}

	public Dueno getDueno() {
		return dueno;
	}

	public void setDueno(Dueno dueno) {
		this.dueno = dueno;
	}

	public List<Dueno> getDuenos() {
		return duenos;
	}

	public void setDuenos(List<Dueno> duenos) {
		this.duenos = duenos;
	}

	public Paseador getPaseador() {
		return paseador;
	}

	public void setPaseador(Paseador paseador) {
		this.paseador = paseador;
	}

	public List<Paseador> getPaseadores() {
		return paseadores;
	}

	public void setPaseadores(List<Paseador> paseadores) {
		this.paseadores = paseadores;
	}


}
