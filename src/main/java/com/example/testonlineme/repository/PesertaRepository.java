package com.example.testonlineme.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.testonlineme.model.Peserta;

@Repository
public interface PesertaRepository extends CrudRepository<Peserta, Long> {
	Peserta findByEmailAndPassword(String email, String password);
	@Query(value = "Select * from [Testtimeme].[dbo].[peserta] a left join [Testtimeme].[dbo].[peserta_test] b on b.peserta_id = a.id where b.peserta_id is null",nativeQuery = true)
	List<Peserta> findByPesertaBytest();
	@Query(value = "Select * FROM [Testtimeme].[dbo].[peserta]  where status='Active'",nativeQuery = true)
	List<Peserta> listPesertaActive();
	@Query(value = "SELECT * FROM [Testtimeme].[dbo].[peserta] where id not in(select peserta_id from [Testtimeme].[dbo].[peserta_test] where test_id=:id)",nativeQuery = true)
	List<Peserta>findByPesertaBytestid(@Param("id") long id);
	@Query(value = "select a.password from Peserta a where a.password=:password and a.email=:email")
	public String findByPassword(@Param("password") String password,@Param("email") String email);
}
