package br.com.bomdestino.sgm.msoauth.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

	@GetMapping("/health")
	public ResponseEntity<String> getHealth(){
		return new ResponseEntity<String>("up", HttpStatus.OK);
	}
}
