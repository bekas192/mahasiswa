/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mahasiswa.controller;

/**
 *
 * @author 300
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
        
@Controller

public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "home";
    }
}
