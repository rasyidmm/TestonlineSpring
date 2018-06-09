package com.example.testonlineme.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.testonlineme.model.Soal;

@Repository
public interface SoalRepository extends CrudRepository<Soal, Long>{

}
