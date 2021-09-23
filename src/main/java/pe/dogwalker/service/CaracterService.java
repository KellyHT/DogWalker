package pe.dogwalker.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.dogwalker.model.entity.Caracter;
import pe.dogwalker.model.repository.CaracterRepository;

@Named
public class CaracterService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CaracterRepository caracterRepository;
	
	@Transactional
	public Long insert(Caracter caracter) throws Exception {
		return caracterRepository.insert(caracter);
	}
	
	public Long update(Caracter caracter) throws Exception {
		return caracterRepository.update(caracter);
	}

	@Transactional
	public void delete (Caracter caracter) throws Exception {
		caracterRepository.delete(caracter);
	}
	
	public List<Caracter> findAll() throws Exception {
		return caracterRepository.findAll();
	}
	
	public List<Caracter> findByName(String name) throws Exception {
		return caracterRepository.findByName(name);
	}
	
	
}
