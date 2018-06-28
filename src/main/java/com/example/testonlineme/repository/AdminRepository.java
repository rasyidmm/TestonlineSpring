package com.example.testonlineme.repository;

import com.example.testonlineme.model.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
    Admin findByEmailAndPassword(String email,String password);
    @Query(value = "Select * FROM [Testtimeme].[dbo].[admin]  where status='Active'",nativeQuery = true)
    List<Admin> listAdminActive();
}
