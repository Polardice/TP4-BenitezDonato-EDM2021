package ar.unju.edu.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.unju.edu.edm.model.Home;

@Controller
public class HomeController {

	@Autowired
	Home unHome;

	@GetMapping({ "/", "/login", "/home", "/index", "/login?error=true" })
	public String cargarHome(Model model) {
		return "home";
	}
}