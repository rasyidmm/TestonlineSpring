package com.example.testonlineme.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.testonlineme.model.PesertaProfil;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PesertaProfilRepository extends CrudRepository<PesertaProfil ,Long> {

}
