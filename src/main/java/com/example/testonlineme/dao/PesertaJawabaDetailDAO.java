package com.example.testonlineme.dao;

import com.example.testonlineme.model.PesertaJawabaDetail;

import java.util.List;

public interface PesertaJawabaDetailDAO {
    public List<PesertaJawabaDetail> getAllPesertaJawabaDetail();
    public PesertaJawabaDetail getById(long id);
    public void SaveOrUpdate(PesertaJawabaDetail pjd);
    public void deletePesertaJawabaDetail(long id);
    public void deletePesertaJawabaDetail(PesertaJawabaDetail pjd);
}
