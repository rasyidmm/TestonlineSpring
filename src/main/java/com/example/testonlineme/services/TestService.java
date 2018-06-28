package com.example.testonlineme.services;

import com.example.testonlineme.dao.TestDAO;
import com.example.testonlineme.model.Test;
import com.example.testonlineme.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TestService implements TestDAO {

    @Autowired
    TestRepository testrepository;
    @Override
    public List<Test> getAllTest() {
        List<Test>lt = new ArrayList<>();
        testrepository.findAll().forEach(lt::add);
        return lt;
    }

    @Override
    public Test getById(long id) {
        Test t = testrepository.findById(id).get();
        return t;
    }

    @Override
    public void SaveOrUpdate(Test t) {
        testrepository.save(t);
    }

    @Override
    public void deleteTest(long id) {
        testrepository.deleteById(id);
    }

    @Override
    public void deleteTest(Test t) {
        testrepository.delete(t);
    }

    public List<Test> findByKeterangan(String Keterangan) {
        return testrepository.findByKeterangan(Keterangan);
    }
    public List<Test> findByStatus(String Status){
        return testrepository.findByStatus(Status);
    }
}
