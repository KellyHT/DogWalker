package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Can;

public interface ICanService {
	public void insertar(Can can);
	public List<Can> listar();
	public void eliminar(int idCan);
}
