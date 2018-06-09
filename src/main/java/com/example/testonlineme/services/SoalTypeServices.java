package com.example.testonlineme.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testonlineme.dao.SoalTypeDAO;
import com.example.testonlineme.model.SoalType;
import com.example.testonlineme.repository.SoalTypeRepository;

@Service
public class SoalTypeServices implements SoalTypeDAO {
	@Autowired
	SoalTypeRepository soaltyperepository;
	@Override
	public List<SoalType> getAllSoalType() {
		List<SoalType> st = new ArrayList<>();
		soaltyperepository.findAll().forEach(st::add);
		return st;
	}

	@Override
	public SoalType getById(long id) {
		SoalType st = soaltyperepository.findById(id).get();
		return st;
	}

	@Override
	public void SaveOrUpdate(SoalType st) {
		soaltyperepository.save(st);
		
	}

	@Override
	public void deleteSoalType(long id) {
		soaltyperepository.deleteById(id);
		
	}

	@Override
	public void deleteSoalType(SoalType st) {
		soaltyperepository.delete(st);
		
	}

}
