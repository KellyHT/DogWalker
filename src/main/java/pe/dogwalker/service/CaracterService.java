package pe.dogwalker.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.dogwalker.model.entity.Caracter;
import pe.dogwalker.model.repository.CaracterRepository;

@Named
public class CaracterService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CaracterRepository caracterRepository;
	
	public List<Caracter> findAll() throws Exception {
		return caracterRepository.findAll();
	}
	

}
