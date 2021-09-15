package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IDetalleSolicitudDao;
import pe.edu.upc.entity.DetalleSolicitud;
import pe.edu.upc.service.IDetalleSolicitudService;

@Named
@RequestScoped
public class DetalleSolicitudServiceImpl implements IDetalleSolicitudService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IDetalleSolicitudDao dsD;
	
	@Override
	public void insertar(DetalleSolicitud detalleSolicitud) {
		dsD.insertar(detalleSolicitud);		
	}

	@Override
	public List<DetalleSolicitud> listar() {
		return dsD.listar();
	}

	@Override
	public void eliminar(int idDetalleSolicitud) {
		dsD.eliminar(idDetalleSolicitud);		
	}
	
}
