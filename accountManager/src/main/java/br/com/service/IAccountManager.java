package br.com.service;

import br.com.model.Usuario;


public interface IAccountManager {

	public void save(Usuario user);

	public Usuario find(Long id);

	public Usuario find(String login);

	public Usuario find(String login, String senha);

	public void update(Usuario user);

	public void remove(Long id);

}
