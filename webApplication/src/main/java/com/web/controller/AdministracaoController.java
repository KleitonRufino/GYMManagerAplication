package com.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.model.Client;
import br.com.service.IClientManager;
import br.com.service.impl.ClientManagerImpl;

@Controller
@RequestMapping("administracao")
public class AdministracaoController {
	private IClientManager managerClient;
	public AdministracaoController() {
		this.managerClient = new ClientManagerImpl();
	}
	
	
	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public String listarClientes(Model model){
		List<Client> clients = this.managerClient.findAll();
		model.addAttribute("clientes", clients);
		return "admin/lista";
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public String cadastrarNovoCliente(Model model){
		return "admin/novo";
	}
	
	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public String editar(Long id, Model model){
		model.addAttribute("cliente", this.managerClient.find(id));
		return "admin/editar";
	}
	
}
