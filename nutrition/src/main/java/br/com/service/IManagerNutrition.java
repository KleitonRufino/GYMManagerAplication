package br.com.service;

import java.util.List;

import br.com.model.Nutrition;

public interface IManagerNutrition {
	
	public void save(Nutrition nutrition, Long idUsuario);
	
	public List<Nutrition> findNutritionActual(Long id_user);
	
	public List<Nutrition> historyNutriton(Long idUser);
	
	public void update(Nutrition nutrition);
	
	public void delete(Long idNutrition);
	
}
