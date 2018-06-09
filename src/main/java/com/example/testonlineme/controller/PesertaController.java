package com.example.testonlineme.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.testonlineme.dao.PesertaDAO;
import com.example.testonlineme.model.Peserta;
import com.example.testonlineme.model.PesertaProfil;
import com.example.testonlineme.services.PesertaProfilServices;
import com.example.testonlineme.services.PesertaServices;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sound.midi.Patch;


@Controller
@SessionAttributes("penggunaaktif")
public class PesertaController {
	
	@Autowired
	PesertaServices pesertaservice;

	@Autowired
	PesertaProfilServices pesertaprofilservices;
	public List<Peserta> pl = new ArrayList<>();
	public List<PesertaProfil> ppl = new ArrayList<>();

	@RequestMapping("peserta")
	 public ModelAndView MasterPeserta() {
		return new  ModelAndView("HalamanPeserta","ListPesertaProfil",pesertaprofilservices.getAllPesertaProfil());
	 }
	/*@RequestMapping("peserta")
	public List<Peserta> MasterPeserta2() {
		return pesertaservice.getAllPeserta();
	}*/

	@RequestMapping(value = "/viewpeserta")
	public ModelAndView  viewPeserta(@RequestParam("id") long id){
		return  new ModelAndView("HalamanViewPeserta","PesertaProfil",pesertaprofilservices.getById(id));
	}
	 @RequestMapping(value = "/tambahpeserta", method = RequestMethod.GET)
	 public String formInsertPeserta(){
		 return "HalamanTambahPeserta";
	 }

	 public String SaveDirectory= "D:/LawenconBootcamp/Spring/TestOnlineme/src/main/resources/static/image/users/";
	 @RequestMapping(value = "/tambahpeserta", method = RequestMethod.POST)
	 public String prosesInsertPeserta(@ModelAttribute("Peserta") Peserta p, @ModelAttribute("PesertaProfil") PesertaProfil pp, @RequestParam("poto") MultipartFile file, RedirectAttributes redirectAttributes){
		 try {
			 byte[] bytes = file.getBytes();
			 Path path = Paths.get(SaveDirectory +file.getOriginalFilename());
			 Files.write(path, bytes);
			 pp.setNama_foto(file.getOriginalFilename());
			 pesertaservice.SaveOrUpdate(p, pp);
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	    return "redirect:peserta";
	 }
	 @RequestMapping(value = "/updateprofil", method = RequestMethod.GET)
	 public ModelAndView formUpdatePesertaProfil(@RequestParam("id") long id){
		return new ModelAndView("HalamanUpdatePesertaProfil","PesertaProfil",pesertaprofilservices.getById(id));
	 }

	 @RequestMapping(value = "/updateprofil", method = RequestMethod.POST)
	 public String prosesUpdatePesertaProfil(@RequestParam("poto") MultipartFile file,@RequestParam("id")long id, RedirectAttributes redirectAttributes,@ModelAttribute("PesertaProfil") PesertaProfil pp, @ModelAttribute("Peserta") Peserta p){
		 try {
			 byte[] bytes = file.getBytes();
			 Path path = Paths.get(SaveDirectory +file.getOriginalFilename());
			 Files.write(path, bytes);
			 pp.setNama_foto(file.getOriginalFilename());
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		 pesertaprofilservices.SaveOrUpdate(pp);
		 return "redirect:peserta";
//		 return pp.getPeserta().getId().toString();
	 }
	 @RequestMapping(value = "/updatepeserta",method = RequestMethod.GET)
	 public ModelAndView formUpdatePeserta(@RequestParam("id") long id){
	 	return new ModelAndView("HalamanUpdatePeserta","Peserta",pesertaservice.getById(id));
	 }
	@RequestMapping(value = "/updatepeserta",method = RequestMethod.POST)
	 public String prosesUpdatePeserta(@ModelAttribute("Peserta") Peserta p){
	 	pesertaservice.UpdatePeserta(p);
	 	return "redirect:peserta";
	 }
	 @RequestMapping(value = "/deletepeserta")
	 public String deletePeserta(@RequestParam("id") long id){
		PesertaProfil pp = pesertaprofilservices.getById(id);
		Peserta p = pp.getPeserta();
		pesertaservice.deletePeserta(pp,p);
		return "redirect:peserta";
	 }
}
