package com.example.testonlineme.services;

import com.example.testonlineme.dao.TestSubSoalDAO;
import com.example.testonlineme.model.TestSub;
import com.example.testonlineme.model.TestSubSoal;
import com.example.testonlineme.repository.TestSubSoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
@Service
public class TestSubSoalService implements TestSubSoalDAO {
    @Autowired
    TestSubSoalRepository testSubSoalRepository;
    @Override
    public List<TestSubSoal> getAllTestSubSoal() {
        List<TestSubSoal> ltss = new ArrayList<>();
        testSubSoalRepository.findAll().forEach(ltss::add);
        return ltss;
    }

    @Override
    public TestSubSoal getById(long id) {
        TestSubSoal tss = testSubSoalRepository.findById(id).get();
        return tss;
    }

    @Override
    public void SaveOrUpdate(TestSubSoal tbs) {
        testSubSoalRepository.save(tbs);
    }

    @Override
    public void deleteTestSub(long id) {
        testSubSoalRepository.deleteById(id);
    }

    @Override
    public void UpdateTestSub(TestSubSoal tbs) {
        testSubSoalRepository.delete(tbs);
    }
    public List<TestSubSoal>findByidTestSub(long id){
        return testSubSoalRepository.findByidTestSub(id);
    }
    public List<BigInteger> findSoalByTestId(BigInteger id){
       return testSubSoalRepository.findByTestId(id);
    }
}
