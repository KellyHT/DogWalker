package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IPersonalidadDao;
import pe.edu.upc.entity.Personalidad;
import pe.edu.upc.service.IPersonalidadService;

@Named
@RequestScoped
public class PersonalidadServiceImpl implements IPersonalidadService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IPersonalidadDao dD;
	
	@Override
	public void insertar(Personalidad personalidad) {
		dD.insertar(personalidad);		
	}

	@Override
	public List<Personalidad> listar() {
		return dD.listar();
	}

	@Override
	public void eliminar(int idPersonalidad) {
		dD.eliminar(idPersonalidad);		
	}
	
}
