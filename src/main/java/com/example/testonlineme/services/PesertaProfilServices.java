package com.example.testonlineme.services;

import java.util.ArrayList;
import java.util.List;

import com.example.testonlineme.model.Peserta;
import com.example.testonlineme.repository.PesertaRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testonlineme.dao.PesertaProfilDAO;
import com.example.testonlineme.model.PesertaProfil;
import com.example.testonlineme.repository.PesertaProfilRepository;

@Service
public class PesertaProfilServices implements PesertaProfilDAO {




	@Autowired
	PesertaProfilRepository pesertaprofilrepository;
	@Autowired
	PesertaRepository pesertarepository;
	@Override
	public List<PesertaProfil> getAllPesertaProfil() {
		List<PesertaProfil> lpp = new ArrayList<>();
		pesertaprofilrepository.findAll().forEach(lpp:: add);
		return lpp;
	}

	@Override
	public PesertaProfil getById(long id) {
		PesertaProfil pp = pesertaprofilrepository.findById(id).get();
		return pp ;
	}

	@Override
	public void SaveOrUpdate(PesertaProfil pp) {
		pesertaprofilrepository.save(pp);
		
	}

	@Override
	public void deletePesertaProfil(long id) {
		pesertaprofilrepository.deleteById(id);
		pesertarepository.deleteById(id);
		
	}

	@Override
	public void deletePesertaProfil(PesertaProfil pp) {
		pesertaprofilrepository.delete(pp);
		
	}



}
