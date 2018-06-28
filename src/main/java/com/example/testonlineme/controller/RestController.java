package com.example.testonlineme.controller;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import com.example.testonlineme.model.*;
import com.example.testonlineme.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	PesertaTestService pesertaTestService;
	@Autowired
	TestSubSoalService testSubSoalService;
	@Autowired
	SoalServices soalServices;
	@Autowired
	PesertaProfilServices pesertaprofilservices;
	@Autowired
	PesertaServices pesertaServices;
	@Autowired
	TestSubService testSubService;
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
	@RequestMapping(value = "/apipassexit")
	public boolean isPassExist(@RequestParam("password") String password, @Param("email") String email) throws NoSuchAlgorithmException {
		return pesertaServices.getExisPassword(password,email);
	}
	@RequestMapping(value = "/restaallsoal")
	public List<Soal>getAll(){
		return soalServices.getAllSoal();
	}

	@RequestMapping(value = "/soalbytestid",method = RequestMethod.GET)
	public List<Soal> findSoalByTestId( @RequestParam("id") BigInteger id){
		List <BigInteger>lb= testSubSoalService.findSoalByTestId(id);
		List<Soal> ls = new ArrayList<>();
		for(BigInteger i:lb){
			Soal s	 = soalServices.getById(i.longValue());
			ls.add(s);
		}
		return ls;
	}
	@RequestMapping(value = "/pesertabytestid",method = RequestMethod.GET)
	public List<PesertaTest> psertaByTestid(@RequestParam("id")long id){
		return pesertaTestService.findByidTest(id);
	}
}
