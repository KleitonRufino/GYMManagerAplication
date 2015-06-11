package com.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
		model.addAttribute("erro", "Usuário e/ou senha inválidos");
		return "login";
	}

	@RequestMapping(value = "/efetuaLogin", method = RequestMethod.POST)
	public String efetuaLogin(@RequestParam(value = "email") String email,
			@RequestParam(value = "senha") String senha, HttpSession session) {
		if ("adm@email.com".equals(email) && "1234".equals(senha))
			return "/administracao/index";
		else if ("user@email.com".equals(email) && "1234".equals(senha))
			return "/cliente/index";
		return "redirect:loginfailed";
		
	}
}
