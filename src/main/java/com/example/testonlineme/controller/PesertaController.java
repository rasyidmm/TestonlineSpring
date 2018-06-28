package com.example.testonlineme.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.example.testonlineme.halpper.enkriphelper;
import com.example.testonlineme.model.Admin;
import com.example.testonlineme.services.AdminService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import org.apache.commons.io.FilenameUtils;
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

import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Patch;
import javax.sql.DataSource;


@Controller
@SessionAttributes("penggunaaktif")
public class PesertaController {
	public Date updateDate;
	String currentDate = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
	@Autowired
	PesertaServices pesertaservice;
	@Autowired
	PesertaProfilServices pesertaprofilservices;
	@Autowired
	AdminService adminService;
	@Autowired
	private DataSource dataSource;
	private JasperReport jasperReport;
	private JasperPrint jasperPrint;
	public List<Peserta> pl = new ArrayList<>();
	public List<PesertaProfil> ppl = new ArrayList<>();

	@RequestMapping("peserta")
	 public ModelAndView MasterPeserta() {
		return new  ModelAndView("HalamanPeserta","ListPesertaProfil",pesertaprofilservices.listPesertaProfilActive());
	 }
	 @RequestMapping("exportpeserta")
	 public String ExportPerserta(){
		return "HalamanEksportPerserta";
//		 return new  ModelAndView("HalamanEksportPerserta","ListPesertaProfil",pesertaprofilservices.listPesertaProfilActive());
	 }
	@RequestMapping(value = "/viewpeserta")
	public ModelAndView  viewPeserta(@RequestParam("id") long id){
		return  new ModelAndView("HalamanViewPeserta","PesertaProfil",pesertaprofilservices.getById(id));
	}
	 @RequestMapping(value = "/tambahpeserta", method = RequestMethod.GET)
	 public String formInsertPeserta(){
		 return "HalamanTambahPeserta";
	 }
//	@SessionAttribute("penggunaaktif") Admin admins

	 public final String SaveDirectory= "D:/LawenconBootcamp/Spring/TestOnlineme/target/classes/static/image/users/";
	 @RequestMapping(value = "/tambahpeserta", method = RequestMethod.POST)
	 public String prosesInsertPeserta(@ModelAttribute("Peserta") Peserta p, @ModelAttribute("PesertaProfil") PesertaProfil pp, @RequestParam("poto") MultipartFile file, RedirectAttributes redirectAttributes, @RequestParam("password")String password,@SessionAttribute("penggunaaktif") Admin admins){
		 try {
			 byte[] bytes = file.getBytes();
			 String nama= file.getOriginalFilename().replace(file.getOriginalFilename(), FilenameUtils.getBaseName(file.getOriginalFilename()).concat(currentDate) + "." + FilenameUtils.getExtension(file.getOriginalFilename())).toLowerCase();
			 pp.setNama_foto(nama);
			 pp.setStatus("Active");
			 p.setCreateDate(new Date());
			 p.setCreateBy(admins.getNama());
			 pp.setUpdateDate(new Date());
			 pp.setCreateBy(admins.getNama());
			 p.setPassword(enkriphelper.md5(password));
			 Path path = Paths.get(SaveDirectory +nama);
			 Files.write(path, bytes);
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
	 public String prosesUpdatePesertaProfil(@RequestParam("poto") MultipartFile file,@RequestParam("id")long id, RedirectAttributes redirectAttributes,@ModelAttribute("PesertaProfil") PesertaProfil pp, @ModelAttribute("Peserta") Peserta p,@SessionAttribute("penggunaaktif") Admin admins){
		 try {
			 if(file.isEmpty()==true){

			 }else {
			 byte[] bytes = file.getBytes();
			 String nama= file.getOriginalFilename().replace(file.getOriginalFilename(), FilenameUtils.getBaseName(file.getOriginalFilename()).concat(currentDate) + "." + FilenameUtils.getExtension(file.getOriginalFilename())).toLowerCase();
			 Path path = Paths.get(SaveDirectory +nama);
			 pp.setNama_foto(nama);
			 Files.write(path, bytes);}
			 pp.setStatus("Active");
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		 pp.setUpdateBy(admins.getNama());
		 pp.setUpdateDate(new Date());
		 pesertaprofilservices.SaveOrUpdate(pp);
		 return "redirect:peserta";
//		 return pp.getPeserta().getId().toString();
	 }
	 @RequestMapping(value = "/updatepeserta",method = RequestMethod.GET)
	 public ModelAndView formUpdatePeserta(@RequestParam("id") long id){
	 	return new ModelAndView("HalamanUpdatePeserta","Peserta",pesertaservice.getById(id));
	 }
	@RequestMapping(value = "/updatepeserta",method = RequestMethod.POST)
	 public String prosesUpdatePeserta(@SessionAttribute("penggunaaktif") Admin admins,@ModelAttribute("Peserta") Peserta p,@RequestParam("password")String password) throws NoSuchAlgorithmException {
		p.setPassword(enkriphelper.md5(password));
		p.setUpdateBy(admins.getNama());
		p.setUpdateDate(new Date());
	 	pesertaservice.UpdatePeserta(p);
	 	return "redirect:peserta";
	 }
	 @RequestMapping(value = "/deletepeserta")
	 public String deletePeserta(@RequestParam("id") long id){
		PesertaProfil pp = pesertaprofilservices.getById(id);
		pp.setStatus("Disable");
//		Peserta p = pp.getPeserta();
//		pesertaservice.deletePeserta(pp,p);
		 pesertaprofilservices.SaveOrUpdate(pp);
		return "redirect:peserta";
	 }

//	 public String printPerserta(@ModelAttribute("Perserta") Peserta peserta, @ModelAttribute("PesertaProfil") PesertaProfil pesertaProfil, HttpServletResponse response){
//		 InputStream printPesertastream = getClass().getResourceAsStream("/Cherrytesttime.jrxml");
//		 try {
//			 jasperReport = JasperCompileManager.compileReport(printPesertastream);
//		 } catch (JRException e) {
//			 e.printStackTrace();
//		 }
//		 JRPdfExporter exporter = new JRPdfExporter();
//		 Map<String,Object> parameters =  new HashMap<>();
//		 parameters.put("title","Peserta");
//		 parameters.put("condotion","SELECT *  FROM [Testtimeme].[dbo].[peserta] a join [Testtimeme].[dbo].[peserta_profil] b on a.id = b.peserta_id");
//
//		 try {
//			 jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,dataSource.getConnection());
//			 response.setContentType("application/x-download");
//			 response.addHeader("Content-disposition","attachment; filename=LaporanPrint");
//			 OutputStream out = response.getOutputStream();
//			 JasperExportManager.exportReportToPdfStream(jasperPrint,out);
//		 } catch (JRException e) {
//			 e.printStackTrace();
//		 } catch (SQLException e) {
//			 e.printStackTrace();
//		 } catch (IOException e) {
//			 e.printStackTrace();
//		 }
//	 }
}
