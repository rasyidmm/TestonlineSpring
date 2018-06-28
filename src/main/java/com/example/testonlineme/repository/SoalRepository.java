package com.example.testonlineme.repository;

import java.util.List;

import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.testonlineme.model.Soal;

@Repository
public interface SoalRepository extends CrudRepository<Soal, Long>{
    @Query(value = " Select * from [Testtimeme].[dbo].[soal] a left join [Testtimeme].[dbo].[test_sub_soal] b on b.soal_id = a.id where b.soal_id is null   ",nativeQuery = true)
    List<Soal> findBySoalTestSoal();
    @Query(value = "select * from [Testtimeme].[dbo].[soal] where status='Active'",nativeQuery = true)
    List<Soal> jumlahSoal();
    @Query(value = "select * from [Testtimeme].[dbo].[soal] where status='Active'",nativeQuery = true)
    List<Soal>ListSoalByActive();
    @Query(value = "SELECT * FROM [Testtimeme].[dbo].[soal] where id not in(Select soal_id from [Testtimeme].[dbo].[test_sub_soal] where test_sub_id=:id)",nativeQuery = true)
    List<Soal>findSoalBySubSoalid(@Param("id")long id);

}
