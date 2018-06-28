package com.example.testonlineme.controller;

import com.example.testonlineme.component.EmailServiceImpl;
import com.example.testonlineme.model.*;
import com.example.testonlineme.repository.TestRepository;
import com.example.testonlineme.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.PublicKey;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("penggunaaktif")
public class TestController {
    @Autowired
    EmailServiceImpl emailServiceimpl;
    @Autowired
    TestRepository testRepository;
    @Autowired
    TestSubSoalService testSubSoalService;
    @Autowired
    SoalServices soalServices;
    @Autowired
    TestSubService testSubService;
    @Autowired
    TestService testService;
    @Autowired
    PesertaServices pesertaServices;
    @Autowired
    PesertaTestService pesertaTestService;

    @RequestMapping("/test")
    public ModelAndView MasterTest(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("teslismenungggu",testService.findByStatus("Menunggu"));
        mav.addObject("teslistselesai",testService.findByStatus("Selesai"));
        mav.setViewName("HalamanTest");
        return mav;
//        return new ModelAndView("HalamanTest","testlist",testService.findByStatus("Menunggu"));
    }
    @RequestMapping(value = "/tambahtest", method = RequestMethod.GET)
    public String tambahTest(){
        return "HalamanTambahTest";
    }

    @RequestMapping(value = "/prosestambahtest",method = RequestMethod.POST)
    public String prosesTambahTest(@ModelAttribute("Test")Test test,@SessionAttribute("penggunaaktif") Admin admins){
        test.setKeterangan("proses");
        test.setCreateBy(admins.getNama());
        test.setCreateDate(new Date());
        testService.SaveOrUpdate(test);
        return "redirect:testdibuat";
    }
    @RequestMapping("testdibuat")
    public ModelAndView testDibuat(@ModelAttribute("Test")Test test){
        ModelAndView mav = new ModelAndView();
        List<Test> listproses = testService.findByKeterangan("proses");
        mav.addObject("listproses",listproses);
        mav.setViewName("HalamanTestdiBuat");
        return mav;
    }
    @RequestMapping(value = "/updatetest", method = RequestMethod.GET)
    public ModelAndView updatetes(@ModelAttribute("Test") Test test,@RequestParam("id") long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("test",testService.getById(id));
        mav.addObject("listsubtestt",testSubService.findByidTest(id));
        mav.setViewName("HalamanUpdateTest");
        return mav;
    }
    @RequestMapping(value = "/prosesupdatetest",method = RequestMethod.POST)
    public String prosesUpdateTest(@ModelAttribute("Test") Test test,@SessionAttribute("penggunaaktif") Admin admins){
        test.setKeterangan("proses");
        test.setUpdateBy(admins.getNama());
        test.setUpdateDate(new Date());
        testService.SaveOrUpdate(test);
        return "redirect:testdibuat";
    }
    @RequestMapping(value = "/tambahsubt",method = RequestMethod.GET)
    public ModelAndView formTambahSt(@RequestParam("id")long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("test",testService.getById(id));
        mav.addObject("listSubtest",testSubService.findByidTest(id));
        mav.setViewName("HalamanTambahSubtest");
        return mav;
    }
    @RequestMapping(value = "/listsub",method = RequestMethod.GET)
    public ModelAndView listSubtest(@ModelAttribute("TestSub")TestSub testSub,@RequestParam("id") long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("listSubtest",testSubService.findByidTest(id));
        mav.addObject("Test",testService.getById(id));
        mav.setViewName("HalamanListSubtest");
        return mav;
    }
    @RequestMapping(value = "prosestambahst",method = RequestMethod.POST)
    public String prosestambahSt(@ModelAttribute("TestSub")TestSub testsub , @RequestParam("id") long id,@SessionAttribute("penggunaaktif") Admin admins){
        testsub.setTest(testService.getById(id));
        testsub.setCreateBy(admins.getNama());
        testsub.setCreateDate(new Date());
        testSubService.SaveOrUpdate(testsub);
        return "redirect:listsub?id="+id;
    }
    @RequestMapping(value = "/formupdatesubtest",method = RequestMethod.GET)
    public ModelAndView formUpdateSubtest(@ModelAttribute("TestSub") TestSub testSub,@RequestParam("id") long id){
        return new ModelAndView("HalamanUpdateSubtest","testsub",testSubService.getById(id));
    }
    @RequestMapping(value = "/prosesupdatesubtest",method = RequestMethod.POST)
    public  String prosesupdatesubtest(@ModelAttribute("TestSub")TestSub testSub,@RequestParam("ids")long ids,@SessionAttribute("penggunaaktif") Admin admins){
        testSub.setTest(testService.getById(ids));
        testSub.setUpdateBy(admins.getNama());
        testSub.setUpdateDate(new Date());
        testSubService.SaveOrUpdate(testSub);
        return "redirect:listsub?id="+ids;
    }
    @RequestMapping(value = "/hapussubtest")
    public String deleteSubTest(@RequestParam("id")long id, @RequestParam("ids") long ids,@SessionAttribute("penggunaaktif") Admin admins){
       TestSub ts = testSubService.getById(id);
       List<TestSubSoal> ltss = ts.getTestSubSoals();
       testSubService.deletesubtes(ts,ltss);
       return "redirect:listsub?id="+ids;
    }
    @RequestMapping(value = "pilihsoal",method = RequestMethod.GET)
    public ModelAndView pilihSoal(@ModelAttribute("Soal")Soal soal,@ModelAttribute("TestSubSoal")TestSubSoal testsubsoal,@RequestParam("id")long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("subtest",testSubService.getById(id));
        mav.addObject("listSoal",soalServices.findSoalBySubSoalid(id));
        mav.setViewName("HalamanPilihSoal");
        return mav;
    }
    @RequestMapping(value = "/prosespilihsoal", method = RequestMethod.POST)
    public String prosesPilihSoal(@SessionAttribute("penggunaaktif") Admin admins,@ModelAttribute("TestSubSoal") TestSubSoal testSubSoal,@RequestParam("id")long id,@RequestParam("ids")long ids){
        testSubSoal.setTestSub(testSubService.getById(id));
        testSubSoal.setSoal(soalServices.getById(ids));
        testSubSoal.setCreateBy(admins.getNama());
        testSubSoal.setUpdateDate(new Date());
        testSubSoalService.SaveOrUpdate(testSubSoal);
        return "redirect:listsoalsub?id="+id;
    }
    @RequestMapping(value = "listsoalsub", method = RequestMethod.GET)
    public ModelAndView listSoalTestSub(@ModelAttribute("TestSubSoal")TestSubSoal testSubSoal,@RequestParam("id")long id){
//        return new ModelAndView("HalamanListSubTestSoal","listSoalSub",testSubSoalService.findByidTestSub(id));
        ModelAndView mav = new ModelAndView();
        mav.setViewName("HalamanListSubTestSoal");
        mav.addObject("listSoalSub",testSubSoalService.findByidTestSub(id));
        mav.addObject("subtest",testSubService.getById(id));
        return mav;
    }
    @RequestMapping(value = "hapussoalpilihan")
    public String hapusSoalPilihan(@RequestParam("id")long id,@RequestParam("ids")long ids){
        testSubSoalService.deleteTestSub(ids);
        return "redirect:listsoalsub?id="+id;
    }
    @RequestMapping(value = "/formtambahpeserttest",method = RequestMethod.GET)
    public ModelAndView pilihPeserta(@RequestParam("id")long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("test",testService.getById(id));
        mav.addObject("listpeserta",pesertaServices.findByPesertaBytestid(id));
        mav.setViewName("HalamanPilihPeserta");
        return mav;
    }
    @RequestMapping(value = "/prosestambahpesertatest",method = RequestMethod.POST)
    public String prosesPilihPeserta(@ModelAttribute("peserta")Peserta peserta,@SessionAttribute("penggunaaktif") Admin admins,@ModelAttribute("PesertaTest")PesertaTest pesertatest,@RequestParam("id")long id,@RequestParam("ids")long ids){
        pesertatest.setPeserta(pesertaServices.getById(ids));
        pesertatest.setTest(testService.getById(id));
        pesertatest.setCreateBy(admins.getNama());
        pesertatest.setCreateDate(new Date());
        pesertaTestService.SaveOrUpdate(pesertatest);
        return "redirect:listpesertatest?id="+id;
    }
    @RequestMapping(value = "/listpesertatest",method = RequestMethod.GET)
    public ModelAndView listPesertatest(@RequestParam("id")long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("listpesertats",pesertaTestService.findByidTest(id));
        mav.addObject("test",testService.getById(id));
        mav.setViewName("HalamanListPesertatest");
        return mav;
    }
    @RequestMapping(value = "/deletepesertates")
    public String deletepesertapilihan(@RequestParam("id") long id,@RequestParam("ids")long ids){
        pesertaTestService.deletePesertaTest(ids);
        return "redirect:listpesertatest?id="+id;
    }
    @RequestMapping(value = "prosestestjadi")
    public String ProsesSelesai(@SessionAttribute("penggunaaktif") Admin admins,@RequestParam("id")long id,@ModelAttribute("Test") Test test) {
        Test t = testService.getById(id);
        t.setKeterangan(null);
        t.setStatus("Menunggu");
        t.setCreateDate(new Date());
        t.setCreateBy(admins.getNama());
        testService.SaveOrUpdate(t);
        return "redirect:test";
    }

    @RequestMapping(value = "viewtestdibuat",method = RequestMethod.GET)
    public ModelAndView viewTestfinal(@RequestParam("id") long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("listpesertatsss",pesertaTestService.findByidTest(id));
        mav.addObject("listTest",testService.findByKeterangan("Proses"));
        mav.addObject("listtestsub",testSubService.findByidTest(id));
        mav.addObject("Test",testService.getById(id));
        mav.setViewName("HalamanViewTestdibuat");
        return mav;
    }
    @RequestMapping(value = "hapustest")
    public String HapusTestdibua(@RequestParam("id")long id){
        Test t = testService.getById(id);
        t.setStatus("Disable");
        t.setKeterangan("Disable");
        testService.SaveOrUpdate(t);
        return "redirect:test";
    }
    @RequestMapping(value = "/viewtestspeserta")
    public ModelAndView viewPesertaBytest(@RequestParam("id")long id){
        return new ModelAndView("HalamanEksportTestPeserta","idpeserta",id);
    }
    @RequestMapping(value = "/viewtestssoal")
    public ModelAndView viewSoalBytest(@RequestParam("id")long id){
        return new ModelAndView("HalamanEksportTestSoal","idsoal",id);
    }
}
