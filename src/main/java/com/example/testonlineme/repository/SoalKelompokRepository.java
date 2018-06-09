package com.example.testonlineme.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.testonlineme.model.SoalKelompok;

@Repository
public interface SoalKelompokRepository extends CrudRepository<SoalKelompok, Long>{

}
