/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mahasiswa.service;

import com.mahasiswa.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 300
 */
@Repository
public interface UserService{
    List <User> listUser();
    User saveOrUpdate(User user);
    User getIdUser(Integer id);
    void hapus(Integer id);
    
}
