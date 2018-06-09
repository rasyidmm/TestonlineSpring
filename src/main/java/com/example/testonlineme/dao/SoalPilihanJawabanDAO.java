package com.example.testonlineme.dao;

import com.example.testonlineme.model.SoalPilihanJawaban;

import java.util.List;

public interface SoalPilihanJawabanDAO {
    public List<SoalPilihanJawaban> getAllSoalPilihan();
    public SoalPilihanJawaban getById(long id);
    public void SaveOrUpdate(SoalPilihanJawaban spj);
    public void deleteSoalpilihan(long id);
    public void deleteSoalpilihan(List<SoalPilihanJawaban> spjl);
    public List<SoalPilihanJawaban> findSoalpilihanbyidSoal(long id);
    public void deletesoallist(long id);
}
