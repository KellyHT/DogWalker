package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Tiempo;

public interface ITiempoDao {
	public void insertar(Tiempo tiempo);
	public List<Tiempo> listar();
	public void eliminar(int idTiempo);
}
