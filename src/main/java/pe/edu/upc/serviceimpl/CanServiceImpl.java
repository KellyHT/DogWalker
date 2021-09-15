package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ICanDao;
import pe.edu.upc.entity.Can;
import pe.edu.upc.service.ICanService;

@Named
@RequestScoped
public class CanServiceImpl implements ICanService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ICanDao cD;
	
	@Override
	public void insertar(Can can) {
		cD.insertar(can);		
	}

	@Override
	public List<Can> listar() {
		return cD.listar();
	}

	@Override
	public void eliminar(int idCan) {
		cD.eliminar(idCan);		
	}
	
}
