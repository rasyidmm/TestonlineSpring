package com.example.testonlineme.dao;

import com.example.testonlineme.model.Test;

import java.util.List;

public interface TestDAO {
    public List<Test> getAllTest();
    public Test getById(long id);
    public void SaveOrUpdate(Test t);
    public void deleteTest(long id);
    public void deleteTest(Test t);
//
}
