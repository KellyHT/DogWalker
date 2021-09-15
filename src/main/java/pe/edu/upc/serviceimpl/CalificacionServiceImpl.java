package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ICalificacionDao;
import pe.edu.upc.entity.Calificacion;
import pe.edu.upc.service.ICalificacionService;

@Named
@RequestScoped
public class CalificacionServiceImpl implements ICalificacionService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ICalificacionDao cD;
	
	@Override
	public void insertar(Calificacion calificacion) {
		cD.insertar(calificacion);		
	}

	@Override
	public List<Calificacion> listar() {
		return cD.listar();
	}

	@Override
	public void eliminar(int idCalificacion) {
		cD.eliminar(idCalificacion);		
	}
	
}
