package br.com.service;

import java.util.List;

import br.com.model.Notification;

public interface IManagerNotification {
	public void save(Notification notification, Long idCliente);
	
	public List<Notification> findBy(Long idCliente);
	
	public List<Notification> findAll();
}

