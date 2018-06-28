package com.example.testonlineme.services;

import com.example.testonlineme.dao.PesertaJawabaDetailDAO;
import com.example.testonlineme.model.PesertaJawabaDetail;
import com.example.testonlineme.repository.PesertaJawabaDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PesertaJawabaDetailService implements PesertaJawabaDetailDAO {
    @Autowired
    PesertaJawabaDetailRepository pesertaJawabaDetailRepository;
    @Override
    public List<PesertaJawabaDetail> getAllPesertaJawabaDetail() {
        List<PesertaJawabaDetail> lpjd = new ArrayList<>();
        pesertaJawabaDetailRepository.findAll().forEach(lpjd::add);
        return lpjd;
    }

    @Override
    public PesertaJawabaDetail getById(long id) {

        PesertaJawabaDetail pjd = pesertaJawabaDetailRepository.findById(id).get();
        return pjd;
    }

    @Override
    public void SaveOrUpdate(PesertaJawabaDetail pjd) {
        pesertaJawabaDetailRepository.save(pjd);
    }

    @Override
    public void deletePesertaJawabaDetail(long id) {
        pesertaJawabaDetailRepository.deleteById(id);
    }

    @Override
    public void deletePesertaJawabaDetail(PesertaJawabaDetail pjd) {
        pesertaJawabaDetailRepository.delete(pjd);
    }
}
