package pe.dogwalker.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.dogwalker.model.entity.Tarjeta;
import pe.dogwalker.model.repository.TarjetaRepository;

@Named
public class TarjetaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TarjetaRepository tarjetaRepository;
	
	public List<Tarjeta> findAll() throws Exception {
		return tarjetaRepository.findAll();
	}
	

}
