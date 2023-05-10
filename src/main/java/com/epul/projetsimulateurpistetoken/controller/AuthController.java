package com.epul.projetsimulateurpistetoken.controller;

import com.epul.projetsimulateurpistetoken.dto.UtilisateurDto;
import com.epul.projetsimulateurpistetoken.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UtilisateurDto userDto) {
        return ResponseEntity.ok(authService.authenticateUser(userDto));
    }

    /*@PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UtilisateurDto userDto) {
        try {
            return ResponseEntity.ok(authService.createUser(userDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }*/
}
