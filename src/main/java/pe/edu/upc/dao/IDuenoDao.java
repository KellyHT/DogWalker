package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Dueno;

public interface IDuenoDao {
	public void insertar(Dueno dueno);
	public List<Dueno> listar();
	public void eliminar(int idDueno);
}
