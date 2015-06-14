package br.com.service;

import br.com.model.User;

public interface IAccountManager {
	
	public User findUserById(Long idUser);

	public User findUserByLogin(String login);

	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(Long idUser);

}
