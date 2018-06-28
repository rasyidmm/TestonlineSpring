package com.example.testonlineme.dao;

import com.example.testonlineme.model.TestSub;
import com.example.testonlineme.model.TestSubSoal;

import java.util.List;

public interface TestSubDAO {
    public List<TestSub> getAllTestSub();
    public TestSub getById(long id);
    public void SaveOrUpdate(TestSub tb);
    public void deleteTestSub(long id);
    public void UpdateTestSub(TestSub tb);
    public void deletesubtes(TestSub ts, List<TestSubSoal> ltss);
}
