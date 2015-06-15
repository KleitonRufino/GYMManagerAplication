package br.com.service.impl;

import br.com.dao.UserDAO;
import br.com.model.Usuario;
import br.com.service.IAccountManager;

public class AccountManager implements IAccountManager {
	private UserDAO dao;

	public AccountManager() {
		this.dao = new UserDAO();
	}

	@Override
	public void save(Usuario user) {
		this.dao.save(user);
	}

	@Override
	public Usuario find(Long id) {
		return this.dao.find(id);
	}

	@Override
	public Usuario find(String login) {
		return this.dao.find(login);
	}

	@Override
	public Usuario find(String login, String senha) {
		return this.dao.find(login, senha);
	}

	@Override
	public void update(Usuario user) {
		this.dao.update(user);
	}

	@Override
	public void remove(Long id) {
		this.dao.remove(id);
	}

}
