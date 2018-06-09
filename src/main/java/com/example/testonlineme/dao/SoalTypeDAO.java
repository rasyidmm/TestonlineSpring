package com.example.testonlineme.dao;

import java.util.List;

import com.example.testonlineme.model.SoalType;



public interface SoalTypeDAO {
	public List<SoalType> getAllSoalType();
	public SoalType getById(long id);
	public void SaveOrUpdate(SoalType st);
	public void deleteSoalType(long id);
	public void deleteSoalType(SoalType st);
}
