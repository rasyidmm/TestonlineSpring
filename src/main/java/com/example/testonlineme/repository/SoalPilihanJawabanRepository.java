package com.example.testonlineme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.testonlineme.model.SoalPilihanJawaban;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface SoalPilihanJawabanRepository extends CrudRepository<SoalPilihanJawaban, Long> {

    @Query ("select sp from SoalPilihanJawaban sp where sp.id=:id")
    List<SoalPilihanJawaban> findByidSoal (@Param("id") long id);
    @Query ("delete from SoalPilihanJawaban sp where sp =:id")
    void deleteAllByidsoal(@Param("id")long id);

//    delete from soal_pilihan_jawaban where soal_id = 9

}
