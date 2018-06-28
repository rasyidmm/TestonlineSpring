package com.example.testonlineme.dao;

import com.example.testonlineme.model.TestSubSoal;

import java.util.List;

public interface TestSubSoalDAO {
    public List<TestSubSoal> getAllTestSubSoal();
    public TestSubSoal getById(long id);
    public void SaveOrUpdate(TestSubSoal tbs);
    public void deleteTestSub(long id);
    public void UpdateTestSub(TestSubSoal tbs);
}
