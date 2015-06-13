package br.com.service.impl;

import java.util.List;

import br.com.dao.ClientDAO;
import br.com.model.Client;
import br.com.service.IClientManager;

public class ClientManagerImpl implements IClientManager {

	private ClientDAO dao;

	public ClientManagerImpl() {
		this.dao = new ClientDAO();
	}

	@Override
	public void save(Client client, Long idUser) {
		this.dao.save(client, idUser);
	}

	@Override
	public Client find(Long id) {
		return this.dao.find(id);
	}

	@Override
	public List<Client> findAll() {
		return this.dao.findAll();
	}

	@Override
	public List<Client> findName(String nome) {
		return this.dao.findName(nome);
	}

	@Override
	public void update(Client client) {
		this.dao.update(client);
	}

	@Override
	public void remove(Long id) {
		this.dao.remove(id);
	}

}
