package com.example.testonlineme.repository;

import com.example.testonlineme.model.TestSub;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestSubRepository extends CrudRepository<TestSub, Long> {
//    @Query("select sp from SoalPilihanJawaban sp where sp.id=:id")
//    List<SoalPilihanJawaban> findByidSoal (@Param("id") long id);
    @Query("select ts from TestSub ts where ts.test.id=:id")
    List<TestSub> findByidTest(@Param("id") long id);
}
