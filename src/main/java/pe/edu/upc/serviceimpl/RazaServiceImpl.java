package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IRazaDao;
import pe.edu.upc.entity.Raza;
import pe.edu.upc.service.IRazaService;

@Named
@RequestScoped
public class RazaServiceImpl implements IRazaService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IRazaDao rD;
	
	@Override
	public void insertar(Raza raza) {
		rD.insertar(raza);		
	}

	@Override
	public List<Raza> listar() {
		return rD.listar();
	}

	@Override
	public void eliminar(int idRaza) {
		rD.eliminar(idRaza);		
	}
	
}
