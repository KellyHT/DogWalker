package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IPaseadorDao;
import pe.edu.upc.entity.Paseador;
import pe.edu.upc.service.IPaseadorService;

@Named
@RequestScoped
public class PaseadorServiceImpl implements IPaseadorService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IPaseadorDao dD;
	
	@Override
	public void insertar(Paseador paseador) {
		dD.insertar(paseador);		
	}

	@Override
	public List<Paseador> listar() {
		return dD.listar();
	}

	@Override
	public void eliminar(int idPaseador) {
		dD.eliminar(idPaseador);		
	}
	
}
