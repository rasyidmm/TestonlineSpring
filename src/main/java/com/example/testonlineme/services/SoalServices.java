package com.example.testonlineme.services;

import java.util.ArrayList;
import java.util.List;

import com.example.testonlineme.model.SoalKelompok;
import com.example.testonlineme.model.SoalPilihanJawaban;
import com.example.testonlineme.model.SoalType;
import com.example.testonlineme.repository.SoalPilihanJawabanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testonlineme.dao.SoalDAO;
import com.example.testonlineme.model.Soal;
import com.example.testonlineme.repository.SoalRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class SoalServices implements SoalDAO {
	@Autowired
	SoalPilihanJawabanServices soalPilihanJawabanServices;
	@Autowired
	SoalServices soalservices;
	@Autowired
	SoalKelompokServices soalkelompokservice;
	@Autowired
	SoalTypeServices soaltypeservices;
	@Autowired
	SoalRepository soalrepository;
	@Autowired
	SoalPilihanJawabanRepository soalPilihanJawabanRepository;
	@Override
	public List<Soal> getAllSoal() {
		List<Soal> s =new ArrayList<>();
		soalrepository.findAll().forEach(s::add);
		return s;
	}

	@Override
	public Soal getById(long id) {
		Soal s = soalrepository.findById(id).get();
		return s;
	}

	@Override
	public void SaveOrUpdate(Soal s) {
		soalrepository.save(s);

	}

	@Override
	public void deleteSoal(long id) {
		soalrepository.deleteById(id);
		
	}

	@Override
	public void deleteSoal(Soal s) {
		soalrepository.delete(s);
		
	}

	@Override
	public void SaveSoal(Soal s, long nts, long nks, String pl, int kj, String pl1, int kj1) {
		s.setSoalType(soaltypeservices.getById(nts));
		s.setSoalKelompok(soalkelompokservice.getById(nks));
		soalservices.SaveOrUpdate(s);
		SoalPilihanJawaban spj = new SoalPilihanJawaban();
		spj.setSoal(s);
		spj.setPilihanjawaban1(pl);
		spj.setKuncijawaban(kj);
		SoalPilihanJawaban spj1 = new SoalPilihanJawaban();
		spj1.setSoal(s);
		spj1.setPilihanjawaban1(pl1);
		spj1.setKuncijawaban(kj1);
		List<SoalPilihanJawaban> ljps = new ArrayList<>();
		ljps.add(spj);
		ljps.add(spj1);
		soalPilihanJawabanServices.insertSemuaJawaban(ljps);
	}

	@Override
	public void updateSoal(@RequestParam("id") long id,@ModelAttribute("Soal") Soal s, @RequestParam("nama_type_soal") long nts,
						   @RequestParam("nama_kelomok_soal") long nks,
						   @RequestParam("id1")long idl,
						   @RequestParam("pilihanjawaban1") String pl,
						   @RequestParam("kuncijawaban1")int kj,
						   @RequestParam("id2")long id2,
						   @RequestParam("pilihanjawaban2") String pl1,
						   @RequestParam("kuncijawaban2")int kj1) {
		s.setId(id);
		s.setSoalType(soaltypeservices.getById(nts));
		s.setSoalKelompok(soalkelompokservice.getById(nks));
		soalservices.SaveOrUpdate(s);
		SoalPilihanJawaban spj1 = soalPilihanJawabanServices.getById(idl);
		spj1.setId(idl);
		spj1.setPilihanjawaban1(pl);
		spj1.setKuncijawaban(kj);
		SoalPilihanJawaban spj2 = soalPilihanJawabanServices.getById(id2);
		spj2.setId(id2);
		spj2.setPilihanjawaban1(pl1);
		spj2.setKuncijawaban(kj1);
		List<SoalPilihanJawaban> ljps = new ArrayList<>();
		ljps.add(spj1);
		ljps.add(spj2);
		soalPilihanJawabanServices.insertSemuaJawaban(ljps);
	}

	@Override
	public void deletesemua(Soal s, List<SoalPilihanJawaban> ls) {
		soalPilihanJawabanRepository.deleteAll(ls);
		soalrepository.delete(s);
	}

}
