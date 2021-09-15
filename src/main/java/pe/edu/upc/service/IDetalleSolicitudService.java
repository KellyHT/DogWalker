package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.DetalleSolicitud;

public interface IDetalleSolicitudService {
	public void insertar(DetalleSolicitud detalleSolicitud);
	public List<DetalleSolicitud> listar();
	public void eliminar(int idDetalleSolicitud);
}
