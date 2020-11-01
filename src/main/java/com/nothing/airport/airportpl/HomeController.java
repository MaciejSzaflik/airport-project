package com.nothing.airport.airportpl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  HomeController() {

  }


  @RequestMapping(value = "/greetings")
	public String index() {
		return "index"; 
	}
}
