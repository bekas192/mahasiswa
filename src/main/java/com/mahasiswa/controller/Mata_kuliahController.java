/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mahasiswa.controller;

import com.mahasiswa.model.Mata_kuliah;
import com.mahasiswa.model.Nilai;
import com.mahasiswa.service.Mata_kuliahService;
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
@RequestMapping("kampus/mk")
@RestController

public class Mata_kuliahController {
     private Mata_kuliahService mata_kuliahService;
     @Autowired
    public void setUserService(Mata_kuliahService mata_kuliahService) {
        this.mata_kuliahService = mata_kuliahService;
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Mata_kuliah> Mata_kuliahList(){
    return mata_kuliahService.listMata_kuliah();
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String simpanDataUser(@RequestBody Mata_kuliah mata_kuliah){
        mata_kuliahService.saveOrUpdate(mata_kuliah);
        return "SUCESSS";
    }
    
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.PUT, produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public String editData(@PathVariable Integer id,@RequestBody Mata_kuliah mata_kuliah){
        Mata_kuliah mk = mata_kuliahService.getIdMata_kuliah(id);

        mk.setKd_mk(mata_kuliah.getKd_mk());
        mk.setName(mata_kuliah.getName());

        

        mata_kuliahService.saveOrUpdate(mk);
        return "SUCCESS";

    }
}
