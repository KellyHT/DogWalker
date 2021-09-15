package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Pago;

public interface IPagoService {
	public void insertar(Pago pago);
	public List<Pago> listar();
	public void eliminar(int idPago);
}
