package br.com.service;

import java.util.List;

import br.com.model.Client;

public interface IClientManager {
	public void save(Client client,Long idUser);
	public Client find(Long id);
	public List<Client> findAll();
	public List<Client> findName(String nome);
	public void update(Client client);
	public void remove(Long id);
}
