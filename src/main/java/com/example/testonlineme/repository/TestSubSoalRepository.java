package com.example.testonlineme.repository;

import com.example.testonlineme.model.Soal;
import com.example.testonlineme.model.TestSub;
import com.example.testonlineme.model.TestSubSoal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

public interface TestSubSoalRepository extends CrudRepository<TestSubSoal, Long> {
    @Query("select tss from TestSubSoal tss where tss.testSub.id=:id")
    List<TestSubSoal> findByidTestSub(@Param("id") long id);
    @Query(value = "Select a.soal_id from [Testtimeme].[dbo].[test_sub_soal] a join [Testtimeme].[dbo].[test_sub] b on a.test_sub_id = b.id join [Testtimeme].[dbo].[test] c on b.test_id = c.id where c.id=:id",nativeQuery = true)
    List<BigInteger> findByTestId(@Param("id")BigInteger id);
}
