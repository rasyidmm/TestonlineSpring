package com.example.testonlineme.dao;

import java.util.List;

import com.example.testonlineme.model.Peserta;
import com.example.testonlineme.model.PesertaProfil;

public interface PesertaDAO  {
	public List<Peserta> getAllPeserta();
	public Peserta getById(long id);
	public void SaveOrUpdate(Peserta p, PesertaProfil pp);
	public void deletePeserta(long id);
	public void deletePeserta(PesertaProfil pp, Peserta p);
	public void UpdatePeserta(Peserta p);
	public boolean getExisPassword(String password,String email);
	
	
}
