package com.example.testonlineme.controller;

import com.example.testonlineme.model.Admin;
import com.example.testonlineme.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("penggunaaktif")
public class AdminController {
	@Autowired
	AdminService adminService;

	public List<Admin> la =new ArrayList<>();

	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public ModelAndView getLogin(@ModelAttribute("Admin") Admin a){
		ModelAndView mav = new ModelAndView();
		Admin penggunaaktif = adminService.getLogin(a.getEmail(),a.getPassword());
		mav.addObject("penggunaaktif", penggunaaktif);
		mav.setViewName("HalamanAdmin");
		return mav;
	}
	@RequestMapping(value = "/updateadmin",method = RequestMethod.GET)
	public ModelAndView formUpdate(@RequestParam("id") long id){
		return new ModelAndView("HalamanUpdateAdmin","Admin",adminService.getById(id));
	}
	@RequestMapping(value = "/updateadmin",method = RequestMethod.POST)
	public String prosesUpdateAdmin(@ModelAttribute("Admin")Admin a){
		adminService.SaveOrUpdate(a);
		return "redirect:adminlist";
	}

	@RequestMapping("/adminlogin")
	public String Master() {
		return "HalamanLoginAdmin";
	}
	@RequestMapping("/admin")
	public String Admin() {
		return "HalamanAdmin";
	}
	@RequestMapping("/lihatpeserta")
	public String lihatpeserta() {
		return "HalamanViewPeserta";
	}

	@RequestMapping(value = "/adminlist")
	public ModelAndView Adminlis(){
		return new ModelAndView("HalamanListAdmin","ListAdmin",adminService.getAllAdmin());
	}

	@RequestMapping(value = "/tambahadmin",method = RequestMethod.GET)
	public String formtambah(){
		return "HalamanTambahAdmin";
	}
	@RequestMapping(value = "/tambahadmin",method = RequestMethod.POST)
	public String prosesTambahAdmin(@ModelAttribute("Admin") Admin a){
		adminService.SaveOrUpdate(a);
		return "redirect:adminlist";
	}
	@RequestMapping(value = "/deleteadmin")
	public String deleteADmin(@RequestParam("id") long id){
		adminService.deleteadmin(id);
		return "redirect:adminlist";
	}
}
