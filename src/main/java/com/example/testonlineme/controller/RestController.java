package com.example.testonlineme.controller;

import java.util.List;

import com.example.testonlineme.model.Peserta;
import com.example.testonlineme.model.SoalPilihanJawaban;
import com.example.testonlineme.services.SoalPilihanJawabanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.testonlineme.model.PesertaProfil;
import com.example.testonlineme.services.PesertaProfilServices;
import com.example.testonlineme.services.PesertaServices;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	PesertaProfilServices pesertaprofilservices;
	@Autowired
	PesertaServices pesertaServices;
	@Autowired
	SoalPilihanJawabanServices soalPilihanJawabanServices;
	@RequestMapping("/pesertarest")
	public List<PesertaProfil> gettall(){
		return pesertaprofilservices.getAllPesertaProfil();
	}
	@RequestMapping("restpeserta")
	public List<Peserta> MasterPeserta2() {
		return pesertaServices.getAllPeserta();
	}
	@RequestMapping(value = "/restsoal")
	public List<SoalPilihanJawaban> gg(){
		return soalPilihanJawabanServices.getAllSoalPilihan();
	}
}
