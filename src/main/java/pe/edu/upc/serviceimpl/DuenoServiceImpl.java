package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IDuenoDao;
import pe.edu.upc.entity.Dueno;
import pe.edu.upc.service.IDuenoService;

@Named
@RequestScoped
public class DuenoServiceImpl implements IDuenoService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IDuenoDao dD;
	
	@Override
	public void insertar(Dueno dueno) {
		dD.insertar(dueno);		
	}

	@Override
	public List<Dueno> listar() {
		return dD.listar();
	}

	@Override
	public void eliminar(int idDueno) {
		dD.eliminar(idDueno);		
	}
	
}
