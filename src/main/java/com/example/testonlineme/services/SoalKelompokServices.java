package com.example.testonlineme.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testonlineme.dao.SoalKelompokDAO;
import com.example.testonlineme.model.SoalKelompok;
import com.example.testonlineme.repository.SoalKelompokRepository;

@Service
public class SoalKelompokServices implements SoalKelompokDAO{

	@Autowired
	SoalKelompokRepository soalkelompokrepository;
	
	@Override
	public List<SoalKelompok> getAllSoalKelompok() {
		List<SoalKelompok> lsk = new ArrayList<>();
		soalkelompokrepository.findAll().forEach(lsk::add);
		return lsk;
	}

	@Override
	public SoalKelompok getById(long id) {
		SoalKelompok sk = soalkelompokrepository.findById(id).get();
		return sk;
	}

	@Override
	public void SaveOrUpdate(SoalKelompok sk) {
		soalkelompokrepository.save(sk);
		
	}

	@Override
	public void deleteSoalKelompok(long id) {
		soalkelompokrepository.deleteById(id);
		
	}

	@Override
	public void deleteSoalKelompok(SoalKelompok sk) {
		soalkelompokrepository.delete(sk);
		
	}

	

	
	
}
