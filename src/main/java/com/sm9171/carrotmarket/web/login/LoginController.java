package com.sm9171.carrotmarket.web.login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

	@GetMapping("/login")
	public String login() {
		log.info("LoginPage Open");
		return "login";
	}

}
