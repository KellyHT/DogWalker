package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Estado;

public interface IEstadoService {
	public void insertar(Estado estado);
	public List<Estado> listar();
	public void eliminar(int idEstado);
}
