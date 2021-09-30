package pe.dogwalker.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.dogwalker.model.entity.Estado;
import pe.dogwalker.model.repository.EstadoRepository;

@Named
public class EstadoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EstadoRepository estadoRepository;
	

	
	public List<Estado> findAll() throws Exception {
		return estadoRepository.findAll();
	}
	
	
	
}
