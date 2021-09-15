package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Distrito;

public interface IDistritoService {
	public void insertar(Distrito distrito);
	public List<Distrito> listar();
	public void eliminar(int idDistrito);
}
