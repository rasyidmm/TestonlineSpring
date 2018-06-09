package com.example.testonlineme.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.testonlineme.model.Peserta;

@Repository
public interface PesertaRepository extends CrudRepository<Peserta, Long> {
	Peserta findByEmailAndPassword(String email, String password);
}
