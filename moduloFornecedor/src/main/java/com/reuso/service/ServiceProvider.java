package com.reuso.service;

import java.util.List;

import com.reuso.model.Provider;

public interface ServiceProvider {
	
	public boolean save(Provider provider);
	public boolean update(Provider provider);
	public boolean delete(Provider provider);
	public Provider find(Long id);
	public List<Provider> find(String name);
	public List<Provider> findAll();
}
