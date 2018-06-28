package com.example.testonlineme.services;

import com.example.testonlineme.dao.AdminDAO;
import com.example.testonlineme.model.Admin;
import com.example.testonlineme.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AdminService implements AdminDAO {

    @Autowired
    AdminRepository adminrepository;
    @Override
    public List<Admin> getAllAdmin() {
        List<Admin> al = new ArrayList<>();
        adminrepository.findAll().forEach(al::add);
        return al;
    }

    @Override
    public Admin getById(long id) {
        Admin a = adminrepository.findById(id).get();
        return a;
    }

    @Override
    public void SaveOrUpdate(Admin a) {
        adminrepository.save(a);
    }

    @Override
    public void deleteadmin(long id) {
        adminrepository.deleteById(id);
    }

    @Override
    public void deleteadmin(Admin a) {
        adminrepository.delete(a);
    }

    public Admin getLogin(String email, String password){
       return adminrepository.findByEmailAndPassword(email,password);
    }
    public List<Admin> listAdminActive(){
        return adminrepository.listAdminActive();
    }
}
