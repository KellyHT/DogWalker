package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Personalidad;

public interface IPersonalidadService {
	public void insertar(Personalidad personalidad);
	public List<Personalidad> listar();
	public void eliminar(int idPersonalidad);
}
