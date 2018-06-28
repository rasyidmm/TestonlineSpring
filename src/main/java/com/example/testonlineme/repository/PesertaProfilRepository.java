package com.example.testonlineme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.testonlineme.model.PesertaProfil;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PesertaProfilRepository extends CrudRepository<PesertaProfil ,Long> {
    @Query(value = "Select * FROM [Testtimeme].[dbo].[peserta_profil]  where status='Active'",nativeQuery = true)
    List<PesertaProfil>listPesertaProfilActive();
    @Query(value = "Select * FROM [Testtimeme].[dbo].[peserta_profil]  where status='Active'",nativeQuery = true)
    List<PesertaProfil>jumlahpeserta();
}
