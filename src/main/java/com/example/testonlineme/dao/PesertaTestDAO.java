package com.example.testonlineme.dao;

import com.example.testonlineme.model.PesertaTest;

import java.util.List;

public interface PesertaTestDAO{
    public List<PesertaTest> getAllPesertaTest();
    public PesertaTest getById(long id);
    public void SaveOrUpdate(PesertaTest pt);
    public void deletePesertaTest(long id);
    public void deletePesertaTest(PesertaTest pt);
}
