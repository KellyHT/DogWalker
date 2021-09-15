package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Caracter;

public interface ICaracterService {
	public void insertar(Caracter caracter);
	public List<Caracter> listar();
	public void eliminar(int idCaracter);
}
