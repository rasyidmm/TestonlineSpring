package com.example.testonlineme.repository;

import com.example.testonlineme.model.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
    Admin findByEmailAndPassword(String email,String password);
}
