/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mahasiswa.model;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Entity
public class Mata_kuliah {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    
    private String kd_mk;
    public Mata_kuliah(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKd_mk() {
        return kd_mk;
    }

    public void setKd_mk(String kd_mk) {
        this.kd_mk = kd_mk;
    }


    
}
