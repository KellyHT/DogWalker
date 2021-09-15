package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.DetalleSolicitud;

public interface IDetalleSolicitudDao {
	public void insertar(DetalleSolicitud detalleSolicitud);
	public List<DetalleSolicitud> listar();
	public void eliminar(int idDetalleSolicitud);
}
