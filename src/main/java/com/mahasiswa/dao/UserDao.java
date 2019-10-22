/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mahasiswa.dao;

import com.mahasiswa.model.User;
import com.mahasiswa.service.UserService;
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
public class UserDao implements UserService{
    private EntityManagerFactory emf;
    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<User> listUser() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User saveOrUpdate(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User saved = em.merge(user);
        em.getTransaction().commit();

        return saved;
    }

    @Override
    public User getIdUser(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(User.class,id);
    }

    @Override
    public void hapus(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(User.class , id));
        em.getTransaction().commit();
    }
    
    
}
