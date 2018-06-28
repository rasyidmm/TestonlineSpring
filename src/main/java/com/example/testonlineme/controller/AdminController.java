package com.example.testonlineme.controller;

import com.example.testonlineme.component.EmailServiceImpl;
import com.example.testonlineme.halpper.enkriphelper;
import com.example.testonlineme.model.Admin;
import com.example.testonlineme.services.*;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("penggunaaktif")

public class AdminController implements ErrorController {
	String currentDate = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
	@Autowired
	AdminService adminService;
	@Autowired
	TestService testService;
	@Autowired
	EmailServiceImpl emailServiceimpl;
	@Autowired
	PesertaServices pesertaServices;
	@Autowired
	SoalServices soalServices;
	@Autowired
	PesertaProfilServices pesertaProfilServices;
	public List<Admin> la =new ArrayList<>();

	@RequestMapping(value="login", method = RequestMethod.POST)
	public String login(@ModelAttribute ("Admin") Admin admin,@RequestParam("password")String password,@RequestParam("email")String email,ModelMap mm)  {
		String page;
		Admin p = null;
		try {
			p = adminService.getLogin(email,enkriphelper.md5(password));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		if(p == null || p.getStatus().equals("Disable")) {
			page="redirect:/adminlogin";
		}
		else {
			mm.put("penggunaaktif",p);
			page="redirect:loginn";
		}
		return page;
	}
//	@RequestMapping(value = "/login",method = RequestMethod.POST)
//	public ModelAndView  getLogin(@ModelAttribute("Admin") Admin a,@RequestParam("password")String password,@RequestParam("email")String email){
//		ModelAndView mav = new ModelAndView();
//		Admin penggunaaktif = null;
//		try {
//			penggunaaktif = adminService.getLogin(email,enkriphelper.md5(password));
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		}
//		mav.addObject("penggunaaktif", penggunaaktif);
////		emailServiceimpl.sendMessage("rasyidmaulidmajid@gmail.com","test","halllooooo");
//		mav.setViewName("HalamanAdmin");
//		return mav;
//	}
	@RequestMapping(value = "loginn",method = RequestMethod.GET)
	public ModelAndView getLogin(){
		ModelAndView mav = new ModelAndView();
//		mav.addObject("penggunaaktif",a);
		mav.addObject("teslismenungggu",testService.findByStatus("Menunggu"));
		mav.addObject("pesertajum",pesertaProfilServices.jumlahpesertaprofil());
		mav.addObject("soaljum",soalServices.jumlahSoal());
		mav.setViewName("HalamanAdmin");
		return mav;
	}
	@RequestMapping(value = "/updateadmin",method = RequestMethod.GET)
	public ModelAndView formUpdate(@RequestParam("id") long id){
		return new ModelAndView("HalamanUpdateAdmin","Admin",adminService.getById(id));
	}
	@RequestMapping(value = "/updateadmin",method = RequestMethod.POST)
	public String prosesUpdateAdmin(@ModelAttribute("Admin")Admin a, @RequestParam("password")String password, @RequestParam("poto") MultipartFile file, RedirectAttributes redirectAttributes){
		try {
			if(file.isEmpty()==true){

			}else {
			byte[] bytes = file.getBytes();
			String nama= file.getOriginalFilename().replace(file.getOriginalFilename(), FilenameUtils.getBaseName(file.getOriginalFilename()).concat(currentDate) + "." + FilenameUtils.getExtension(file.getOriginalFilename())).toLowerCase();
			a.setNama_fotoadmin(nama);
			Path path = Paths.get(SaveDirectory +nama);
			Files.write(path, bytes);
			}
			a.setPassword(enkriphelper.md5(password));

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		a.setStatus("Active");
		adminService.SaveOrUpdate(a);
		return "redirect:adminlist";
	}

	@RequestMapping("/adminlogin")
	public String Master() {
		return "HalamanLoginAdmin";
	}
	@RequestMapping("/lihatpeserta")
	public String lihatpeserta() {
		return "HalamanViewPeserta";
	}

	@RequestMapping(value = "/adminlist")
	public ModelAndView Adminlis(){
		return new ModelAndView("HalamanListAdmin","ListAdmin",adminService.listAdminActive());
	}

	@RequestMapping(value = "/tambahadmin",method = RequestMethod.GET)
	public String formtambah(){
		return "HalamanTambahAdmin";
	}

	public final String SaveDirectory= "D:/LawenconBootcamp/Spring/TestOnlineme/target/classes/static/image/users/";
	@RequestMapping(value = "/tambahadmin",method = RequestMethod.POST)
	public String prosesTambahAdmin(@ModelAttribute("Admin") Admin a, @RequestParam("password")String password, @RequestParam("poto") MultipartFile file, RedirectAttributes redirectAttributes){
		try {
			byte[] bytes = file.getBytes();
			String nama= file.getOriginalFilename().replace(file.getOriginalFilename(), FilenameUtils.getBaseName(file.getOriginalFilename()).concat(currentDate) + "." + FilenameUtils.getExtension(file.getOriginalFilename())).toLowerCase();
			a.setPassword(enkriphelper.md5(password));
			a.setStatus("Active");
			a.setNama_fotoadmin(nama);
			Path path = Paths.get(SaveDirectory +nama);
			Files.write(path, bytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		adminService.SaveOrUpdate(a);
		return "redirect:adminlist";
	}
	@RequestMapping(value = "/deleteadmin")
	public String deleteADmin(@RequestParam("id") long id, @ModelAttribute("Admin") Admin admin){
		Admin a = adminService.getById(id);
		a.setStatus("Disable");
		adminService.SaveOrUpdate(a);
		return "redirect:adminlist";
	}
	@RequestMapping("/logout")
	public String goLogOut(HttpSession session, SessionStatus status) {
		status.setComplete();
		session.removeAttribute("penggunaAktif");
		return "redirect:/adminlogin";
	}

	@RequestMapping("/error")
	public String erroeScren(){
		return "HalamanError.html";
	}
	@Override
	public String getErrorPath() {
		return"redirect:error";
	}
}
