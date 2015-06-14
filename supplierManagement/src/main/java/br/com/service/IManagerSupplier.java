package br.com.service;

import br.com.model.Supplier;

public interface IManagerSupplier {

	public Supplier findById(Long idSupplier);

	public Supplier findByName(String nomeSupplier);

	public void addSupplier(Supplier supplier);
	
	public void addSupplierProduct(Long idSupplier, Long idProduct);

	public void updateSupplier(Supplier supplier);

	public void deleteSupplier(Long idSupplier);

}
