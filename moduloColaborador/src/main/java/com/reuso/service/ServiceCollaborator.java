package com.reuso.service;

import java.util.List;

import com.reuso.model.Collaborator;;

public interface ServiceCollaborator {
	public boolean save(Collaborator collaborator);
	public boolean update(Collaborator collaborator);
	public boolean delete(Collaborator collaborator);
	public Collaborator find(Long id);
	public List<Collaborator> find(String name);
	public List<Collaborator> findAll();
}
