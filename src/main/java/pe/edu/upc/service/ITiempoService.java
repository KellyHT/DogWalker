package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Tiempo;

public interface ITiempoService {
	public void insertar(Tiempo tiempo);
	public List<Tiempo> listar();
	public void eliminar(int idTiempo);
}
