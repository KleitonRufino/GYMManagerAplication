package br.com.service;

import java.util.List;

import br.com.model.BodyCondition;

public interface IManagerBodyCondition {
	
	public List<BodyCondition> find();
	
	public List<BodyCondition> findByUser(Long id_user);

	public BodyCondition currentBodyCondition(Long id_user);
	
	public void addBodyCondition(BodyCondition condition, Long id_usuario);
	
	public void delete(BodyCondition condition, Long id_user);
	
}
