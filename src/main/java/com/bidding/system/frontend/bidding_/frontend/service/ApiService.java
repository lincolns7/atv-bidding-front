/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bidding.system.frontend.bidding_.frontend.service;

import com.bidding.system.frontend.bidding_.frontend.model.EditalDTO;
import com.bidding.system.frontend.bidding_.frontend.model.UserRequestDTO;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.service.invoker.HttpMethodArgumentResolver;

/**
 *
 * @author Aluno
 */
@Service
public class ApiService {
    
    private final RestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8081";
    
    public ApiService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    
    public List<EditalDTO> listarEditais(String token){
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity entity = new HttpEntity(headers);
    
        return restTemplate.exchange(BASE_URL + "/api/editais", 
                HttpMethod.GET, entity, new ParameterizedTypeReference<List<EditalDTO>>() {}).getBody();
    }
    public String logar(UserRequestDTO user){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity(headers);
        
        return restTemplate.exchange(BASE_URL + "api/auth/login", 
               HttpMethod.POST, entity, new ParameterizedTypeReference<String>() {}).getBody();
       
    }
}
