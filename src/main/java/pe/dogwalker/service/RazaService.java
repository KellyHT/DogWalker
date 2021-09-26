package pe.dogwalker.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.dogwalker.model.entity.Raza;
import pe.dogwalker.model.repository.RazaRepository;

@Named
public class RazaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private RazaRepository razaRepository;
	

	public List<Raza> findAll() throws Exception {
		return razaRepository.findAll();
	}

}
