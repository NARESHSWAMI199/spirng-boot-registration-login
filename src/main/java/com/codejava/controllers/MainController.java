package com.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String ViewHomePage() {
		return "index";
	}

	@GetMapping("/register")
	public String showSignupPage(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}

	@PostMapping("/proccess_register")
	public String postRegistration(User user) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword= encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepository.save(user);
		return "registor_success";
	}
	
	@GetMapping("/list_users")
	public String viewUserList(Model model) {
		List<User> userList = userRepository.findAll();
		model.addAttribute("listUsers" , userList);
		return "users";
	}
	
	
	

}