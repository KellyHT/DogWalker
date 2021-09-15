package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Estado;

public interface IEstadoDao {
	public void insertar(Estado estado);
	public List<Estado> listar();
	public void eliminar(int idEstado);
}
