package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Distrito;

public interface IDistritoDao {
	public void insertar(Distrito distrito);
	public List<Distrito> listar();
	public void eliminar(int idDistrito);
}
