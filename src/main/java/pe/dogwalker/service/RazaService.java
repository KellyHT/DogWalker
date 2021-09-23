package pe.dogwalker.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.dogwalker.model.entity.Raza;
import pe.dogwalker.model.repository.RazaRepository;

@Named
public class RazaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private RazaRepository razaRepository;
	
	@Transactional
	public Long insert(Raza raza) throws Exception {
		return razaRepository.insert(raza);
	}
	
	public Long update(Raza raza) throws Exception {
		return razaRepository.update(raza);
	}

	@Transactional
	public void delete (Raza raza) throws Exception {
		razaRepository.delete(raza);
	}
	
	public List<Raza> findAll() throws Exception {
		return razaRepository.findAll();
	}
	
	public List<Raza> findByName(String name) throws Exception {
		return razaRepository.findByName(name);
	}
	
	
}
