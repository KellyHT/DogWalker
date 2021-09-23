package pe.dogwalker.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.dogwalker.model.entity.Estado;
import pe.dogwalker.model.repository.EstadoRepository;

@Named
public class EstadoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EstadoRepository estadoRepository;
	
	@Transactional
	public Long insert(Estado estado) throws Exception {
		return estadoRepository.insert(estado);
	}
	
	public Long update(Estado estado) throws Exception {
		return estadoRepository.update(estado);
	}

	public void delete (Estado estado) throws Exception {
		estadoRepository.delete(estado);
	}
	
	public List<Estado> findAll() throws Exception {
		return estadoRepository.findAll();
	}
	
	public List<Estado> findByName(String name) throws Exception {
		return estadoRepository.findByName(name);
	}
	
}
