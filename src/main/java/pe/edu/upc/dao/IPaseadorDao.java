package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Paseador;

public interface IPaseadorDao {
	public void insertar(Paseador paseador);
	public List<Paseador> listar();
	public void eliminar(int idPaseador);
}
