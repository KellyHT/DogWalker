package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Paseador;

public interface IPaseadorService {
	public void insertar(Paseador paseador);
	public List<Paseador> listar();
	public void eliminar(int idPaseador);
}
