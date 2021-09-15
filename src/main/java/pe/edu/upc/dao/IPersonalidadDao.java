package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Personalidad;

public interface IPersonalidadDao {
	public void insertar(Personalidad paseador);
	public List<Personalidad> listar();
	public void eliminar(int idPersonalidad);
}
