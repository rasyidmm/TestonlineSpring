package com.example.testonlineme.services;

import com.example.testonlineme.model.SoalPilihanJawaban;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testonlineme.dao.SoalPilihanJawabanDAO;
import com.example.testonlineme.repository.SoalPilihanJawabanRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SoalPilihanJawabanServices implements SoalPilihanJawabanDAO {

	@Autowired
	SoalPilihanJawabanRepository soalPilihanJawabanRepository;
	public void insertSemuaJawaban(List<SoalPilihanJawaban> listjawaabn){
		soalPilihanJawabanRepository.saveAll(listjawaabn);
	}

	@Override
	public List<SoalPilihanJawaban> getAllSoalPilihan() {
		List<SoalPilihanJawaban> lsp = new ArrayList<>();
		soalPilihanJawabanRepository.findAll().forEach(lsp::add);
		return lsp;
	}

	@Override
	public SoalPilihanJawaban getById(long id) {
		SoalPilihanJawaban spj = soalPilihanJawabanRepository.findById(id).get();
		return spj;
	}

	@Override
	public void SaveOrUpdate(SoalPilihanJawaban spj) {
		soalPilihanJawabanRepository.save(spj);

	}

	@Override
	public void deleteSoalpilihan(long id) {
		soalPilihanJawabanRepository.deleteById(id);
	}

	@Override
	public void deleteSoalpilihan(List<SoalPilihanJawaban> spjl) {
		soalPilihanJawabanRepository.deleteAll(spjl);
	}

	@Override
	public List<SoalPilihanJawaban> findSoalpilihanbyidSoal(long id) {
		return soalPilihanJawabanRepository.findByidSoal(id);
	}

	@Override
	public void deletesoallist(long id) {
		soalPilihanJawabanRepository.deleteAllByidsoal(id);
	}


}
