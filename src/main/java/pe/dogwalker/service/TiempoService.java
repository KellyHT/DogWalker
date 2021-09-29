package pe.dogwalker.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.dogwalker.model.entity.Tiempo;
import pe.dogwalker.model.repository.TiempoRepository;

@Named
public class TiempoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TiempoRepository tiempoRepository;
	
	public List<Tiempo> findAll() throws Exception {
		return tiempoRepository.findAll();
	}
	

}
