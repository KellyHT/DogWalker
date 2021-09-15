package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Raza;

public interface IRazaDao {
	public void insertar(Raza raza);
	public List<Raza> listar();
	public void eliminar(int idRaza);
}
