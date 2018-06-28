package com.example.testonlineme.services;

import com.example.testonlineme.dao.TestSubDAO;
import com.example.testonlineme.model.TestSub;
import com.example.testonlineme.model.TestSubSoal;
import com.example.testonlineme.repository.TestSubRepository;
import com.example.testonlineme.repository.TestSubSoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TestSubService implements TestSubDAO {
    @Autowired
    TestSubRepository testSubRepository;
    @Autowired
    TestSubSoalRepository testSubSoalRepository;
    @Override
    public List<TestSub> getAllTestSub() {

        List<TestSub> ltb = new ArrayList<>();
        testSubRepository.findAll().forEach(ltb::add);
        return ltb;
    }

    @Override
    public TestSub getById(long id) {

        TestSub tb = testSubRepository.findById(id).get();
        return tb;
    }

    @Override
    public void SaveOrUpdate(TestSub tb) {
        testSubRepository.save(tb);
    }

    @Override
    public void deleteTestSub(long id) {
        testSubRepository.deleteById(id);
    }

    @Override
    public void UpdateTestSub(TestSub tb) {
        testSubRepository.delete(tb);
    }

    @Override
    public void deletesubtes(TestSub ts, List<TestSubSoal> ltss) {
        testSubSoalRepository.deleteAll(ltss);
        testSubRepository.delete(ts);
    }
//
    public List<TestSub> findByidTest(long id){
        return testSubRepository.findByidTest(id);
    }


}
