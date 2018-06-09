package com.example.testonlineme.dao;

import java.util.List;

import com.example.testonlineme.model.Peserta;
import com.example.testonlineme.model.PesertaProfil;



public interface PesertaProfilDAO {
	public List<PesertaProfil> getAllPesertaProfil();
	public PesertaProfil getById(long id);
	public void SaveOrUpdate(PesertaProfil pp);
	public void deletePesertaProfil(long id);
	public void deletePesertaProfil(PesertaProfil pp);

}
