/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mahasiswa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor

@Entity
public class Nilai implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn
    private User user;

    @Id
    @ManyToOne
    @JoinColumn
    private Mata_kuliah mata_kuliah;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private double nilai_uts;
    private double nilai_uas;
    private double nilai_tugas;

    private Date publishedDate;

    public Nilai(Mata_kuliah mata_kuliah, Date publishedDate) {
        this.mata_kuliah = mata_kuliah;
        this.publishedDate = publishedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nilai)) return false;
        Nilai that = (Nilai) o;
        return Objects.equals(user.getNama(), that.user.getNama()) &&
                Objects.equals(mata_kuliah.getName(), that.mata_kuliah.getName())&&
                Objects.equals(publishedDate, that.publishedDate)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user.getNama(), mata_kuliah.getName(), publishedDate);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Mata_kuliah getMata_kuliah() {
        return mata_kuliah;
    }

    public void setMata_kuliah(Mata_kuliah mata_kuliah) {
        this.mata_kuliah = mata_kuliah;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getNilai_uts() {
        return nilai_uts;
    }

    public void setNilai_uts(double nilai_uts) {
        this.nilai_uts = nilai_uts;
    }

    public double getNilai_uas() {
        return nilai_uas;
    }

    public void setNilai_uas(double nilai_uas) {
        this.nilai_uas = nilai_uas;
    }

    public double getNilai_tugas() {
        return nilai_tugas;
    }

    public void setNilai_tugas(double nilai_tugas) {
        this.nilai_tugas = nilai_tugas;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }
    
    
}
