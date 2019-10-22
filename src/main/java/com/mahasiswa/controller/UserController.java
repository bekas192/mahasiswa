/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mahasiswa.controller;

import com.mahasiswa.model.User;
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
@RequestMapping("kampus/user")

@RestController
public class UserController {
    private UserService userService;
     @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> UserList(){
    return userService.listUser();
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String simpanDataUser(@RequestBody User user){
        userService.saveOrUpdate(user);
        return "SUCESSS";
    }
    
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.PUT, produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public String editData(@PathVariable Integer id,@RequestBody User user){
        User us = userService.getIdUser(id);

        us.setNama(user.getNama());
        us.setJurusan(user.getJurusan());
        us.setNim(user.getNim());
        us.setRole(user.getRole());

        userService.saveOrUpdate(us);
        return "SUCCESS";

    }
    
}
