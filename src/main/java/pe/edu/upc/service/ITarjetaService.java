package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Tarjeta;

public interface ITarjetaService {
	public void insertar(Tarjeta tarjeta);
	public List<Tarjeta> listar();
	public void eliminar(int idTarjeta);
}
