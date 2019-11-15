package com.digitel.consultasp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.digitel.consultasp.service.ConsultaService;



@RestController
public class TutorialSp {

	public TutorialSp() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping(path = "/ciudad")
	public ResponseEntity<?>  getEstados(HttpServletRequest request, HttpServletResponse response) {	
		
		return ResponseEntity.ok().body(ConsultaService.FindCiudad());
	}
	
	@GetMapping(path = "/ICCID/{idICCID}")
	public ResponseEntity<?>  getIccid(HttpServletRequest request, HttpServletResponse response) {	
		
		return ResponseEntity.ok().body(ConsultaService.FindCiudad());
	}

	
	@GetMapping(path = "/userType/{idProduct}/{vip}")
	public ResponseEntity<?>  getuserType(HttpServletRequest request, HttpServletResponse response, 
			@PathVariable(value="idProduct") String idProduct,@PathVariable(value="vip") String vip) {

		
		return ResponseEntity.ok().body(ConsultaService.ConsultaType(idProduct,vip));
	}
}
