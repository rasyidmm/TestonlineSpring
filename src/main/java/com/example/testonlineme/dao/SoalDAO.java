package com.example.testonlineme.dao;

import java.util.List;

import com.example.testonlineme.model.Soal;
import com.example.testonlineme.model.SoalKelompok;
import com.example.testonlineme.model.SoalPilihanJawaban;
import com.example.testonlineme.model.SoalType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

public interface SoalDAO {
	public List<Soal> getAllSoal();
	public Soal getById(long id);
	public void SaveOrUpdate(Soal s);
	public void deleteSoal(long id);
	public void deleteSoal(Soal s);
	public void SaveSoal(Soal s, @RequestParam("nama_type_soal") long nts, @RequestParam("nama_kelomok_soal") long nks,@RequestParam("pilihanjawaban") String pl,@RequestParam("kuncijawaban")int kj,@RequestParam("pilihanjawaban1") String pl1,@RequestParam("kuncijawaban1")int kj1);
	public void updateSoal(@RequestParam("id") long id,@ModelAttribute("Soal") Soal s, @RequestParam("nama_type_soal") long nts,
						   @RequestParam("nama_kelomok_soal") long nks,
						   @RequestParam("id1")long idl,
						   @RequestParam("pilihanjawaban1") String pl,
						   @RequestParam("kuncijawaban1")int kj,
						   @RequestParam("id2")long id2,
						   @RequestParam("pilihanjawaban2") String pl1,
						   @RequestParam("kuncijawaban2")int kj1);
	public void deletesemua(Soal s,List<SoalPilihanJawaban> ls);
}
