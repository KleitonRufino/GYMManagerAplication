package br.com.service.impl;

import br.com.dao.UserDAO;
import br.com.model.User;
import br.com.service.IAccountManager;

public class AccountManager implements IAccountManager {
	private UserDAO dao;

	public AccountManager() {
		this.dao = new UserDAO();
	}

	@Override
	public User findUserById(Long idUser) {
		return this.findUserById(idUser);
	}

	@Override
	public User findUserByLogin(String login) {
		return this.dao.findUserByLogin(login);
	}

	@Override
	public void addUser(User user) {
		this.dao.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		this.dao.updateUser(user);
	}

	@Override
	public void deleteUser(Long idUser) {
		this.dao.deleteUser(idUser);
	}

}
