package pe.dogwalker.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.dogwalker.model.entity.Can;
import pe.dogwalker.model.entity.Caracter;
import pe.dogwalker.model.entity.Dueno;
import pe.dogwalker.model.entity.Raza;
import pe.dogwalker.service.CanService;
import pe.dogwalker.service.CaracterService;
import pe.dogwalker.service.DuenoService;
import pe.dogwalker.service.RazaService;
import pe.dogwalker.util.Message;

@Named
@SessionScoped
public class CanController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CanService canService;
	
	@Inject
	private RazaService razaService;
	
	@Inject
	private CaracterService caracterService;
	
	@Inject
	private DuenoService duenoService;
	
	private Can can;
	private List<Can> cans;
	private Can canSelect;
	
	private Raza raza;
	private List<Raza> razas;
	
	private Caracter caracter;
	private List<Caracter> caracteres;
	
	private Dueno dueno;
	private List<Dueno> duenos;
	
	
	private String filterName;
	
	@PostConstruct
	public void init() {
		
		can = new Can();
		raza = new Raza();
		dueno = new Dueno();
		caracter= new Caracter();
		
		cans = new ArrayList<Can>();
		razas = new ArrayList<Raza>();
		caracteres = new ArrayList<Caracter>();
		duenos = new ArrayList<Dueno>();
		getAllCans();
	}
	
	
	public void getAllCans() {
		try {
			cans = canService.findAll();
		} catch (Exception e) {
			Message.messageError("Error al cargar Canos: " + e.getMessage());
		}
	}
	
	public String newCan() {
		System.out.print("new can");
		try {
			this.razas = razaService.findAll();
			this.caracteres = caracterService.findAll();
			this.duenos = duenoService.findAll();
			resetForm();
		} catch (Exception e) {
		}
		return "/insertCan";
	}
	
	public void resetForm() {
		this.filterName = "";
		this.can = new Can();
	}
	
	public String listCan() {
		return "/can/list";
	}
	
	public String saveCan() {

		String view="" ;
		try {
			if (can.getIdCan() != null) 
			{
				can.setRaza(raza);
				can.setCaracter(caracter);
				can.setDueno(dueno);
				canService.update(can);
				view = "/GestionarCanes";
				Message.messageInfo("Registro Actualizado Correctamente");
			}
			else 
			{
				can.setRaza(raza);
				can.setCaracter(caracter);
				can.setDueno(dueno);
				canService.insert(can);
				Message.messageInfo("Registro Insertado Correctamente");
				view = "/GestionarCanes";
			}
			this.getAllCans();
			//this.listarCanesPorDueno(dueno.getId());
			
			resetForm();
			
		} 
		catch (Exception e) {
			Message.messageInfo("error "+ e);
			System.out.println("error "+ e);
		}
		return view;
	}
	
	public String editCan() {
		String view = "";
		try 
		{
			if (this.canSelect != null) 
			{
				this.can = canSelect;
				view = "updateCan";
			}
			else 
			{
				Message.messageError("Debe Seleccionar un can");
			}
		} 
		catch (Exception e) {
			Message.messageError("Error  en dueño: " + e.getMessage());
		}
		return view;
	}
	
	public String deleteCan() {
		String view = "";
		try {
			this.can = canSelect;
			canService.delete(this.can);
			Message.messageInfo("Registro Eliminado Correctamente");
			this.getAllCans();
			view = "GestionarCanes";
		} catch (Exception e) {
			Message.messageError("Error en cano " + e.getMessage());
		}
		return view;
	}
	

	
	public String gestionarCanes() {
		
		return "/GestionarCanes";
	}

	
	public void canSelect(SelectEvent e) {
		this.canSelect = (Can)e.getObject();
	}


	public CanService getCanService() {
		return canService;
	}


	public void setCanService(CanService canService) {
		this.canService = canService;
	}


	public RazaService getRazaService() {
		return razaService;
	}


	public void setRazaService(RazaService razaService) {
		this.razaService = razaService;
	}


	public Can getCan() {
		return can;
	}


	public void setCan(Can can) {
		this.can = can;
	}


	public List<Can> getCans() {
		return cans;
	}


	public void setCans(List<Can> cans) {
		this.cans = cans;
	}


	public Can getCanSelect() {
		return canSelect;
	}


	public void setCanSelect(Can canSelect) {
		this.canSelect = canSelect;
	}


	public Raza getRaza() {
		return raza;
	}


	public void setRaza(Raza raza) {
		this.raza = raza;
	}


	public List<Raza> getRazas() {
		return razas;
	}


	public void setRazas(List<Raza> razas) {
		this.razas = razas;
	}


	public Caracter getCaracter() {
		return caracter;
	}


	public void setCaracter(Caracter caracter) {
		this.caracter = caracter;
	}


	public List<Caracter> getCaracteres() {
		return caracteres;
	}


	public void setCaracteres(List<Caracter> caracteres) {
		this.caracteres = caracteres;
	}


	public Dueno getDueno() {
		return dueno;
	}


	public void setDueno(Dueno dueno) {
		this.dueno = dueno;
	}


	public String getFilterName() {
		return filterName;
	}


	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}


	public CaracterService getCaracterService() {
		return caracterService;
	}


	public void setCaracterService(CaracterService caracterService) {
		this.caracterService = caracterService;
	}


	public DuenoService getDuenoService() {
		return duenoService;
	}


	public void setDuenoService(DuenoService duenoService) {
		this.duenoService = duenoService;
	}


	public List<Dueno> getDuenos() {
		return duenos;
	}


	public void setDuenos(List<Dueno> duenos) {
		this.duenos = duenos;
	}
	
	

}
