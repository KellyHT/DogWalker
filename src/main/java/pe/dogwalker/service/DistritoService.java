package pe.dogwalker.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.dogwalker.model.entity.Distrito;
import pe.dogwalker.model.repository.DistritoRepository;

@Named
public class DistritoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DistritoRepository distritoRepository;
	
	public List<Distrito> findAll() throws Exception {
		return distritoRepository.findAll();
	}

}
