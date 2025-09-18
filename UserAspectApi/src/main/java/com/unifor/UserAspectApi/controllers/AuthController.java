package com.unifor.UserAspectApi.controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credential){
        return ResponseEntity.ok("login bem-sucessido! Use credencia");
    }

    @GetMapping("/protected")
    public ResponseEntity<String> protectedendpoint(Authentication authentication){
        return ResponseEntity.ok("Acesso concedido! usuario :" + authentication);
    }
}
