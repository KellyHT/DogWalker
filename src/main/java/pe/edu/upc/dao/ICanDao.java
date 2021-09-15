package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Can;

public interface ICanDao {
	public void insertar(Can can);
	public List<Can> listar();
	public void eliminar(int idCan);
}
