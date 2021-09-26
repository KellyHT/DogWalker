package pe.dogwalker.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.dogwalker.model.entity.Can;
import pe.dogwalker.model.repository.CanRepository;

@Named
public class CanService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CanRepository canRepository;
	
	@Transactional
	public Long insert(Can can) throws Exception {
		
		return canRepository.insert(can);
	}
	@Transactional
	public Long update(Can can) throws Exception {
		return canRepository.update(can);
	}

	@Transactional
	public void delete (Can can) throws Exception {
		canRepository.delete(can);
	}
	
	public List<Can> findAll() throws Exception {
		return canRepository.findAll();
	}
	
	public List<Can> findByName(String name) throws Exception {
		return canRepository.findByName(name);
	}
	
}
