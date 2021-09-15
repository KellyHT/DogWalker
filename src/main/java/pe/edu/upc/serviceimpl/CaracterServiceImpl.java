package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ICaracterDao;
import pe.edu.upc.entity.Caracter;
import pe.edu.upc.service.ICaracterService;

@Named
@RequestScoped
public class CaracterServiceImpl implements ICaracterService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ICaracterDao cD;
	
	@Override
	public void insertar(Caracter caracter) {
		cD.insertar(caracter);		
	}

	@Override
	public List<Caracter> listar() {
		return cD.listar();
	}

	@Override
	public void eliminar(int idCaracter) {
		cD.eliminar(idCaracter);		
	}
	
}
