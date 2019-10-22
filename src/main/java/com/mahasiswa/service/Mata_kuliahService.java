/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mahasiswa.service;

import com.mahasiswa.model.Mata_kuliah;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 300
 */
@Repository
public interface Mata_kuliahService{
    List <Mata_kuliah> listMata_kuliah();
    Mata_kuliah saveOrUpdate(Mata_kuliah mata_kuliah);
    Mata_kuliah getIdMata_kuliah(Integer id);
    void hapus(Integer id);
    
}
