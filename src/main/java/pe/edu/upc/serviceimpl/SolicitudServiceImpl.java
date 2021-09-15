package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ISolicitudDao;
import pe.edu.upc.entity.Solicitud;
import pe.edu.upc.service.ISolicitudService;

@Named
@RequestScoped
public class SolicitudServiceImpl implements ISolicitudService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ISolicitudDao sD;
	
	@Override
	public void insertar(Solicitud solicitud) {
		sD.insertar(solicitud);		
	}

	@Override
	public List<Solicitud> listar() {
		return sD.listar();
	}

	@Override
	public void eliminar(int idSolicitud) {
		sD.eliminar(idSolicitud);		
	}
	
}
