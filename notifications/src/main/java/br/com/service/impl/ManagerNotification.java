package br.com.service.impl;

import java.util.List;

import br.com.dao.NotificationDAO;
import br.com.model.Notification;
import br.com.service.IManagerNotification;

public class ManagerNotification implements IManagerNotification {

	private NotificationDAO dao;

	public ManagerNotification() {
		this.dao = new NotificationDAO();
	}

	@Override
	public void save(Notification notification, Long idCliente) {
		this.dao.save(notification, idCliente);
	}

	@Override
	public List<Notification> findBy(Long idCliente) {
		return this.dao.findBy(idCliente);
	}

	@Override
	public List<Notification> findAll() {
		return this.dao.findAll();
	}

}
