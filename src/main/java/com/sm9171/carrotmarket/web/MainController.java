package com.sm9171.carrotmarket.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MainController {

	@GetMapping()
	public String main() {
		log.info("MainPage Open");
		return "main";
	}

}
