package com.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.model.Client;
import br.com.model.Usuario;
import br.com.service.IClientManager;
import br.com.service.IUsuarioManager;
import br.com.service.impl.ClientManagerImpl;
import br.com.service.impl.UsuarioManagerImpl;

@Controller
@RequestMapping
public class LoginController {

	private IClientManager clientManager;
	private IUsuarioManager usuarioManager;
	private Usuario usuario;

	public LoginController() {
		this.clientManager = new ClientManagerImpl();
		this.usuarioManager = new UsuarioManagerImpl();
	}

	@RequestMapping(value = "/sair", method = RequestMethod.GET)
	public String sair(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		// request.getSession().invalidate();
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
		model.addAttribute("erro", "Usuario e/ou senha invalidos");
		return "login";
	}

	@RequestMapping(value = "/efetuaLogin", method = RequestMethod.POST)
	public String efetuaLogin(@RequestParam(value = "email") String email,
			@RequestParam(value = "senha") String senha,
			HttpServletRequest request) {
		this.usuario = this.usuarioManager.find(email, senha);
		if (this.usuario == null) {
			return "redirect:loginfailed";
		}
		if ("admin@gmail.com".equals(this.usuario.getLogin())) {
			Client client = this.clientManager.findByIdUser(this.usuario
					.getId());
			request.getSession().invalidate();
			HttpSession session = request.getSession(true);
			session.setAttribute("idUsuario", this.usuario.getId());
			session.setAttribute("idCliente", client.getId());
			session.setAttribute("cpfCliente", client.getCpf());
			session.setAttribute("dataNascimentoCliente",
					client.getDataNascimento());
			session.setAttribute("dataVencimentoCliente",
					client.getDataVencimento());
			session.setAttribute("ativoCliente", client.isAtivo());
			session.setAttribute("nomeCliente", client.getNome());
			return "/administracao/index";
		} else
			return "/cliente/index";
	}
}
