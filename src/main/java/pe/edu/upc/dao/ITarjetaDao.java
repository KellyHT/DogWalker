package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Tarjeta;

public interface ITarjetaDao {
	public void insertar(Tarjeta tarjeta);
	public List<Tarjeta> listar();
	public void eliminar(int idTarjeta);
}
