package com.example.testonlineme.dao;

import java.util.List;

import com.example.testonlineme.model.SoalKelompok;



public interface SoalKelompokDAO {
	public List<SoalKelompok> getAllSoalKelompok();
	public SoalKelompok getById(long id);
	public void SaveOrUpdate(SoalKelompok sk);
	public void deleteSoalKelompok(long id);
	public void deleteSoalKelompok(SoalKelompok sk);
}
