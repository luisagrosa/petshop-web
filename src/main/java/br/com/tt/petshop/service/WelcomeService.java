package br.com.tt.petshop.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WelcomeService {

    public String getVersao(){
        return String.format("v1.1"+ LocalDateTime.now().toString());
    }
}
