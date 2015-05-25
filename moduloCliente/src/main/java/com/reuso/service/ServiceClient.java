package com.reuso.service;

import java.util.List;

import com.reuso.model.Client;

public interface ServiceClient {
	public boolean save(Client client);
	public boolean update(Client client);
	public boolean delete(Client client);
	public Client find(Long id);
	public List<Client> find(String name);
	public List<Client> findAll();
}
