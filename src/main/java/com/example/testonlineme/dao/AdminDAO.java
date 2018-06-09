package com.example.testonlineme.dao;

import com.example.testonlineme.model.Admin;

import java.util.List;

public interface AdminDAO {
    public List<Admin> getAllAdmin();
    public Admin getById(long id);
    public void SaveOrUpdate(Admin a);
    public void deleteadmin(long id);
    public void deleteadmin(Admin a);

}
