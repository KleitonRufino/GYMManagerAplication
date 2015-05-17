package com.reuso.controller;

import javax.faces.bean.ManagedBean;

import com.reuso.model.Cliente;
import com.reuso.service.ServiceCliente;
import com.reuso.service.impl.ServiceClienteImpl;

@ManagedBean(name = "ctrlCliente")
public class ControllerCliente {
	
	private Cliente cliente;
	private ServiceCliente serviceCliente;
	
	public ControllerCliente() {
		this.cliente = new Cliente();
		this.serviceCliente = new ServiceClienteImpl();
	}
	public String salvarCliente(){
		this.serviceCliente.salvar(cliente);
		return null;
	}
}
