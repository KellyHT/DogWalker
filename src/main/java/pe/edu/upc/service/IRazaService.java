package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Raza;

public interface IRazaService {
	public void insertar(Raza raza);
	public List<Raza> listar();
	public void eliminar(int idRaza);
}
