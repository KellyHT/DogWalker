package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Caracter;

public interface ICaracterDao {
	public void insertar(Caracter caracter);
	public List<Caracter> listar();
	public void eliminar(int idCaracter);
}
