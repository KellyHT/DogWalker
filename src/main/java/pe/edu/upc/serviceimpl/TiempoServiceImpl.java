package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ITiempoDao;
import pe.edu.upc.entity.Tiempo;
import pe.edu.upc.service.ITiempoService;

@Named
@RequestScoped
public class TiempoServiceImpl implements ITiempoService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ITiempoDao rD;
	
	@Override
	public void insertar(Tiempo tiempo) {
		rD.insertar(tiempo);		
	}

	@Override
	public List<Tiempo> listar() {
		return rD.listar();
	}

	@Override
	public void eliminar(int idTiempo) {
		rD.eliminar(idTiempo);		
	}
	
}
