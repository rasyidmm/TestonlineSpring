package com.example.testonlineme.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.example.testonlineme.component.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testonlineme.dao.PesertaDAO;
import com.example.testonlineme.model.Peserta;
import com.example.testonlineme.model.PesertaProfil;
import com.example.testonlineme.repository.PesertaProfilRepository;
import com.example.testonlineme.repository.PesertaRepository;

@Service
public class PesertaServices  implements PesertaDAO{
	@Autowired
	PesertaRepository pesertarepository;
	@Autowired
	PesertaProfilRepository pesertaprofilrepository;
	@Autowired
	EmailServiceImpl emailServiceimpl;
	@Override
	public List<Peserta> getAllPeserta() {
		List<Peserta> lp = new ArrayList<>();
		pesertarepository.findAll().forEach(lp:: add);
		return lp;
	}

	@Override
	public Peserta getById(long id) {
		Peserta p = pesertarepository.findById(id).get();
		return p ;
	}

	@Override
	public void SaveOrUpdate(Peserta p,PesertaProfil pp) {
		try {
//			emailServiceimpl.sendMessage(p.getEmail(),"test","halllooooo");
			p = pesertarepository.save(p);
			pp.setPeserta(p);
			pesertaprofilrepository.save(pp);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("eror gagal proses : "+e);
		}
		
	}

	@Override
	public void deletePeserta(long id) {
		pesertarepository.deleteById(id);
		
	}

	@Override
	public void deletePeserta(PesertaProfil pp, Peserta p) {
		try {
			pesertaprofilrepository.delete(pp);
			pesertarepository.delete(p);
		}catch (Exception e){
			System.out.println("eror gagal proses : "+e);
		}

	}



	@Override
	public void UpdatePeserta(Peserta p) {
		pesertarepository.save(p);
	}

	@Override
	public boolean getExisPassword(String password, String email) {
		return pesertarepository.findByPassword(password,email)!=null;
	}

	public Peserta getlogin(String email, String password) {
		return pesertarepository.findByEmailAndPassword(email, password);
	}
	
	public List<Peserta>findByPesertaBytestid(long id)
	{
		return pesertarepository.findByPesertaBytestid(id);
	}

	public int jumlahpeserta(){
		return pesertarepository.listPesertaActive().size();
	}
	public List<Peserta>findPesertasByActive(){
		return pesertarepository.listPesertaActive();
	}
}

