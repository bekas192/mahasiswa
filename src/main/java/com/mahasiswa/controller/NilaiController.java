/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mahasiswa.controller;

import com.mahasiswa.model.Nilai;
import com.mahasiswa.model.User;
import com.mahasiswa.service.NilaiService;
import com.mahasiswa.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 300
 */
@RequestMapping("kampus/nilai")
@RestController
public class NilaiController {
    private NilaiService nilaiService;
     @Autowired
    public void setUserService(NilaiService nilaiService) {
        this.nilaiService = nilaiService;
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Nilai> NilaiList(){
    return nilaiService.listNilai();
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String simpanDataUser(@RequestBody Nilai nilai){
        nilaiService.saveOrUpdate(nilai);
        return "SUCESSS";
    }
    
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.PUT, produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public String editData(@PathVariable Integer id,@RequestBody Nilai nilai){
        Nilai n = nilaiService.getIdNilai(id);

        n.setMata_kuliah(nilai.getMata_kuliah());
        n.setNilai_tugas(nilai.getNilai_tugas());
        n.setNilai_uas(nilai.getNilai_uas());
        n.setNilai_uts(nilai.getNilai_uts());
        n.setUser(nilai.getUser());

        nilaiService.saveOrUpdate(n);
        return "SUCCESS";

    }
}
