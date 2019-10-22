/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mahasiswa.dao;

import com.mahasiswa.model.Mata_kuliah;
import com.mahasiswa.model.Nilai;
import com.mahasiswa.service.Mata_kuliahService;
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
public class Mata_kuliahDao implements Mata_kuliahService{
      private EntityManagerFactory emf;
    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<Mata_kuliah> listMata_kuliah() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Mata_kuliah", Mata_kuliah.class).getResultList();
    }

    @Override
    public Mata_kuliah saveOrUpdate(Mata_kuliah mata_kuliah) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Mata_kuliah saved = em.merge(mata_kuliah);
        em.getTransaction().commit();

        return saved;
    }

    @Override
    public Mata_kuliah getIdMata_kuliah(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Mata_kuliah.class,id);
    }

    @Override
    public void hapus(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Mata_kuliah.class , id));
        em.getTransaction().commit();
    }
}
