package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Dueno;

public interface IDuenoService {
	public void insertar(Dueno dueno);
	public List<Dueno> listar();
	public void eliminar(int idDueno);
}
