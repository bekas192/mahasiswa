/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mahasiswa.service;

import com.mahasiswa.model.Nilai;
import com.mahasiswa.model.User;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 300
 */
@Repository
public interface NilaiService {
     List <Nilai> listNilai();
    Nilai saveOrUpdate(Nilai nilai);
    Nilai getIdNilai(Integer id);
    void hapus(Integer id);
    
}
