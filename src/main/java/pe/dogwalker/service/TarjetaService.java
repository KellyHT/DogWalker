package pe.dogwalker.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.dogwalker.model.entity.Tarjeta;
import pe.dogwalker.model.repository.TarjetaRepository;

@Named
public class TarjetaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TarjetaRepository tarjetaRepository;
	
	@Transactional
	public Long insert(Tarjeta tarjeta) throws Exception {
		return tarjetaRepository.insert(tarjeta);
	}
	
	public Long update(Tarjeta tarjeta) throws Exception {
		return tarjetaRepository.update(tarjeta);
	}

	@Transactional
	public void delete (Tarjeta tarjeta) throws Exception {
		tarjetaRepository.delete(tarjeta);
	}
	
	public List<Tarjeta> findAll() throws Exception {
		return tarjetaRepository.findAll();
	}
	
	public List<Tarjeta> findByName(String name) throws Exception {
		return tarjetaRepository.findByName(name);
	}
}
