package com.example.testonlineme.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.testonlineme.model.*;
import com.example.testonlineme.repository.SoalPilihanJawabanRepository;
import com.example.testonlineme.services.SoalPilihanJawabanServices;
import com.example.testonlineme.services.SoalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.testonlineme.services.SoalKelompokServices;
import com.example.testonlineme.services.SoalTypeServices;

@Controller
@SessionAttributes("penggunaaktif")
public class SoalController {
	@Autowired
	SoalTypeServices soaltypeservices;
	@Autowired
	SoalKelompokServices soalkelompokservice;
	@Autowired
	SoalServices soalservices;
	@Autowired
	SoalPilihanJawabanServices soalPilihanJawabanServices;
	public List<SoalType> st = new ArrayList<>();

//=====================================================type Soal========================================================
	@RequestMapping(value="/propertitype",method = RequestMethod.GET)
	public ModelAndView soaltye(@ModelAttribute("SoalType") SoalType st) {
		return new ModelAndView("HalamanPropertiSoalType","ListSoalType",soaltypeservices.getAllSoalType());

	}
	
	@RequestMapping(value = "/tambahtypesoal", method = RequestMethod.POST)
	public String prosestypesoal(@ModelAttribute("SoalType") SoalType st) {
		soaltypeservices.SaveOrUpdate(st);
		return "redirect:propertitype";
	}
	@RequestMapping(value = "/updatetypesoal",method = RequestMethod.GET)
	public ModelAndView updateTypeSoal(@RequestParam("id")int id){
		return new ModelAndView("HalamanUpdateSoalType","SoalType",soaltypeservices.getById(id));
	}

	@RequestMapping(value = "/updatetypesoal",method = RequestMethod.POST)
	public String updateproses(@ModelAttribute("SoalType") SoalType st) {
		soaltypeservices.SaveOrUpdate(st);
		return "redirect:propertitype";
	}
	@RequestMapping(value = "/deletetypesoal")
	public String deletetypesoal(@RequestParam("id") long id){
		soaltypeservices.deleteSoalType(id);
		return "redirect:propertitype";
	}
	//================================================================kelompok Soal========================================
	@RequestMapping(value="/propertikelompok",method = RequestMethod.GET)
	public ModelAndView formsoalKelompok(@ModelAttribute("SoalKelompok") SoalKelompok sk) {
		return new ModelAndView("HalamanPropertiSoalKelompok","ListSoalKelompok",soalkelompokservice.getAllSoalKelompok());
	}
	@RequestMapping(value ="/kelompoksoal", method = RequestMethod.POST)
	public String kelompoksoal(@ModelAttribute("SoalKelompok") SoalKelompok sk) {
		soalkelompokservice.SaveOrUpdate(sk);
		return "redirect:propertikelompok";
	}
	@RequestMapping(value = "/updatekelompoksoal",method = RequestMethod.GET)
	public ModelAndView updateKelompokSoal(@RequestParam("id")int id){
		return new ModelAndView("HalamanUpdateSoalKelompok","SoalKelompok",soalkelompokservice.getById(id));
	}

	@RequestMapping(value = "/updatekelompoksoal",method = RequestMethod.POST)
	public String updateprosesKelompok(@ModelAttribute("SoalKelompok") SoalKelompok sk) {
		soalkelompokservice.SaveOrUpdate(sk);
		return "redirect:propertikelompok";
	}
	@RequestMapping(value = "/deletekelompoksoal")
	public String deletekelompoksoal(@RequestParam("id") long id){
		soalkelompokservice.deleteSoalKelompok(id);
		return "redirect:propertikelompok";
	}
//==============================================SOAL===================================================================
	@RequestMapping(value = "/soal")
	public ModelAndView MasterSoal(@ModelAttribute("Soal") Soal s){
		return new ModelAndView("HalamanSoal","ListSoal",soalservices.getAllSoal());
	}
	@RequestMapping(value = "/tambahsoal",method = RequestMethod.GET)
	public ModelAndView formSoal(@ModelAttribute("SoalKelompok") SoalKelompok sk,@ModelAttribute("SoalType") SoalType st,@ModelAttribute("Soal") Soal s){
		ModelAndView mav = new ModelAndView();
		mav.addObject("ListSoalType",soaltypeservices.getAllSoalType());
		mav.addObject("ListSoalKelompok",soalkelompokservice.getAllSoalKelompok());
		mav.setViewName("HalamanTambahSoal");
		return mav;
	}
	@RequestMapping(value = "/tambahsoal", method = RequestMethod.POST)
	public String insertSOal(@ModelAttribute("Soal") Soal s, @RequestParam("nama_type_soal") long nts, @RequestParam("nama_kelomok_soal") long nks,@RequestParam("pilihanjawaban1") String pl,@RequestParam("kuncijawaban1")int kj,@RequestParam("pilihanjawaban2") String pl1,@RequestParam("kuncijawaban2")int kj1,@ModelAttribute("Admin") Admin A){
		s.setCreateBy("A");
		s.setUpdateBy("A");
		soalservices.SaveSoal(s,nts,nks,pl,kj,pl1,kj1);
		return "redirect:soal";
	}
	@RequestMapping(value = "/updatesoal", method = RequestMethod.GET)
	public ModelAndView formUpdateSoal(@RequestParam("id") long id,@ModelAttribute("SoalType") SoalType st,@ModelAttribute("SoalKelompok")SoalKelompok sk,@ModelAttribute("SoalPilihanJawaban") SoalPilihanJawaban spj){
		ModelAndView mav = new ModelAndView();
		Soal sld = soalservices.getById(id);
		List<SoalPilihanJawaban>splki = sld.getSoalPilihanJawabans();
		mav.addObject("ListSoalType",soaltypeservices.getAllSoalType());
		mav.addObject("ListSoalKelompok",soalkelompokservice.getAllSoalKelompok());
		mav.addObject("ListPilihanSoal",splki);
		mav.addObject("Soal",soalservices.getById(id));
		mav.setViewName("HalamanUpdateSoal");
		return mav;
	}
	@RequestMapping(value = "/updatesoal",method = RequestMethod.POST)
	public String proseUpdateSoal(@RequestParam("id") long id,@ModelAttribute("Soal") Soal s, @RequestParam("nama_type_soal") long nts, @RequestParam("nama_kelomok_soal") long nks, @RequestParam("id1")long idl, @RequestParam("pilihanjawaban1") String pl, @RequestParam("kuncijawaban1")int kj, @RequestParam("id2")long id2, @RequestParam("pilihanjawaban2") String pl1, @RequestParam("kuncijawaban2")int kj1){
		soalservices.updateSoal(id,s,nts,nks,idl,pl,kj,id2,pl1,kj1);
		return "redirect:soal";
	}
	@RequestMapping(value = "/hapussoal")
	public String deleteSoal(@RequestParam("id") long id){
		Soal s =  soalservices.getById(id);
		List<SoalPilihanJawaban> llks = s.getSoalPilihanJawabans();
		soalservices.deletesemua(s,llks);
		return "redirect:soal";
	}
	@RequestMapping(value = "/viewsoal")
	public ModelAndView viewSoal(@RequestParam("id") long id){
		ModelAndView mav = new ModelAndView();
		mav.addObject("Soal",soalservices.getById(id));
		mav.setViewName("HalamanViewSoal");
		return mav;
	}
}
