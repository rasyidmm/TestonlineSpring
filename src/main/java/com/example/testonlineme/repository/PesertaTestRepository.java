package com.example.testonlineme.repository;

import com.example.testonlineme.model.PesertaTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PesertaTestRepository extends CrudRepository<PesertaTest, Long> {
//    @Query ("select ts from TestSub ts where ts.test.id=:id")
//    List<TestSub> findByidTest(@Param("id") long id);
    @Query("select pt from PesertaTest pt where pt.test.id=:id")
    List<PesertaTest>findByidTest(@Param("id")long id);
}
