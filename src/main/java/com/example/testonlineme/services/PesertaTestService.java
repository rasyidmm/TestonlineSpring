package com.example.testonlineme.services;

import com.example.testonlineme.dao.PesertaTestDAO;
import com.example.testonlineme.model.PesertaTest;
import com.example.testonlineme.repository.PesertaTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PesertaTestService implements PesertaTestDAO {
    @Autowired
    PesertaTestRepository pesertaTestRepository;
    @Override
    public List<PesertaTest> getAllPesertaTest() {

        List<PesertaTest> lpt = new ArrayList<>();
        pesertaTestRepository.findAll().forEach(lpt::add);
        return lpt;

    }

    @Override
    public PesertaTest getById(long id) {
        PesertaTest pt = pesertaTestRepository.findById(id).get();
        return pt;
    }

    @Override
    public void SaveOrUpdate(PesertaTest pt) {
        pesertaTestRepository.save(pt);
    }

    @Override
    public void deletePesertaTest(long id) {
        pesertaTestRepository.deleteById(id);
    }

    @Override
    public void deletePesertaTest(PesertaTest pt) {
        pesertaTestRepository.delete(pt);
    }

    public List<PesertaTest> findByidTest(long id){
        return pesertaTestRepository.findByidTest(id);
    }
}
