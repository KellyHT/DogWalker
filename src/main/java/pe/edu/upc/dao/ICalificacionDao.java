package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Calificacion;

public interface ICalificacionDao {
	public void insertar(Calificacion calificacion);
	public List<Calificacion> listar();
	public void eliminar(int idCalificacion);
}
