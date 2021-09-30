package pe.dogwalker.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class LoginController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public String cerrar() {
		String view ="";
	
			view = "master.xhtml";
		
		return view;
	}
	


}
