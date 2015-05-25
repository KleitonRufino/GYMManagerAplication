package com.reuso.service;

import java.util.List;

import com.reuso.model.Billing;

public interface ServiceBilling{
		
	public boolean save(Billing billing);
	public boolean update(Billing billing);
	public boolean delete(Billing billing);
	public Billing find(Long id);
	public List<Billing> find(String nameClient);
	public List<Billing> findAll();
}
