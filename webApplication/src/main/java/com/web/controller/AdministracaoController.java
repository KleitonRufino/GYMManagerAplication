package com.web.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.model.Client;
import br.com.model.Usuario;
import br.com.service.IClientManager;
import br.com.service.IUsuarioManager;
import br.com.service.impl.ClientManagerImpl;
import br.com.service.impl.UsuarioManagerImpl;

@Controller
@RequestMapping("administracao")
public class AdministracaoController {
	private IClientManager managerClient;
	private IUsuarioManager managerUsuario;

	public AdministracaoController() {
		this.managerClient = new ClientManagerImpl();
		this.managerUsuario = new UsuarioManagerImpl();
	}

	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public String listarClientes(Model model) {
		List<Client> clients = this.managerClient.findAll();
		model.addAttribute("clientes", clients);
		return "admin/lista";
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public String cadastrarNovoCliente(Model model) {
		return "admin/novo";
	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public String editarCliente(Long id, Model model) {
		model.addAttribute("cliente", this.managerClient.find(id));
		return "admin/editar";
	}

	@RequestMapping(value = "/alterarCliente", method = RequestMethod.POST)
	public String alterarCliente(Client client, Model model,
			RedirectAttributes redirect) {
		this.managerClient.update(client);
		redirect.addFlashAttribute("info", "Cliente " + client.getNome()
				+ " editado com sucesso");
		return "redirect:clientes";
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "adicionaCliente", method = RequestMethod.POST)
	public String adicionaCliente(@RequestParam("email") String email,
			@RequestParam("nome") String nome, @RequestParam("cpf") Long cpf,
			@RequestParam("telefone") String telefone,
			@RequestParam("dataNascimento") Date dataNascimento, RedirectAttributes redirect) {
		
		Usuario user = new Usuario();
		user.setLogin(email);
		user.setSenha("1234");
			
		Client cliente = new Client();
		cliente.setNome(nome);
		cliente.setTelefone(telefone);
		cliente.setCpf(cpf);
		cliente.setDataNascimento(dataNascimento);
		cliente.setDataVencimento(new Long(new Date(System.currentTimeMillis()).getDay()));
		
		this.managerUsuario.save(user);
		user = this.managerUsuario.find(user.getLogin());
		
		this.managerClient.save(cliente, user.getId());
		redirect.addFlashAttribute("info", "Cliente " + nome  + " adicionado com sucesso");
		return "redirect:clientes";
	}

}
