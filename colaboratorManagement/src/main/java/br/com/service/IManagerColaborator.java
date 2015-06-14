package br.com.service;

import br.com.model.Colaborator;

public interface IManagerColaborator {

	public Colaborator findById(Long idColaborator);

	public Colaborator findByName(String nomeColaborator);

	public void addColaborator(Colaborator colaborator);

	public void updateColaborator(Colaborator colaborator);

	public void deleteColaborator(Long idColaborator);

}
