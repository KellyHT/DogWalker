package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Calificacion;

public interface ICalificacionService {
	public void insertar(Calificacion calificacion);
	public List<Calificacion> listar();
	public void eliminar(int idCalificacion);
}
