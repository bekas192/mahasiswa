/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mahasiswa.dao;

import com.mahasiswa.model.Nilai;
import com.mahasiswa.service.NilaiService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 300
 */
@Service

public class NilaiDao implements NilaiService{

   private EntityManagerFactory emf;
    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<Nilai> listNilai() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Nilai", Nilai.class).getResultList();
    }

    @Override
    public Nilai saveOrUpdate(Nilai nilai) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Nilai saved = em.merge(nilai);
        em.getTransaction().commit();

        return saved;
    }

    @Override
    public Nilai getIdNilai(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Nilai.class,id);
    }

    @Override
    public void hapus(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Nilai.class , id));
        em.getTransaction().commit();
    }
    
}
