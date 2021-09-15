package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Pago;

public interface IPagoDao {
	public void insertar(Pago pago);
	public List<Pago> listar();
	public void eliminar(int idPago);
}
