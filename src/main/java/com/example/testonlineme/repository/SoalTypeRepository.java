package com.example.testonlineme.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.testonlineme.model.SoalType;

@Repository
public interface SoalTypeRepository extends CrudRepository<SoalType, Long> {

}
