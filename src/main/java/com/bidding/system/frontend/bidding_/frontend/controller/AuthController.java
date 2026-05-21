/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bidding.system.frontend.bidding_.frontend.controller;

import com.bidding.system.frontend.bidding_.frontend.model.UserRequestDTO;
import com.bidding.system.frontend.bidding_.frontend.service.ApiService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Aluno
 */
public class AuthController {
    
    private final ApiService apiService;
    
    public AuthController(ApiService apiService){
        this.apiService = apiService;
    }
    
    @PostMapping("/login")
    public String logar(UserRequestDTO dto, HttpSession session){
        try{
            String token = apiService.logar(dto);
            session.setAttribute("token", token);
            return "redirect/editais";
        }catch(Exception e){
            return "login?error=true";
        }
    }
    
}
