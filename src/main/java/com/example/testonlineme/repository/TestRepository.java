package com.example.testonlineme.repository;

import com.example.testonlineme.model.Test;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TestRepository extends CrudRepository<Test,Long> {
//    @Query ("select sp from SoalPilihanJawaban sp where sp.id=:id")
//    List<SoalPilihanJawaban> findByidSoal (@Param("id") long id);
//    @Query("select t from Test t where t order by p")
    List<Test> findByKeterangan(String Keterangan);
    List<Test> findByStatus(String Status);
}
