package com.epul.projetsimulateurpistetoken.controller;

import com.epul.projetsimulateurpistetoken.domains.EntityUtilisateur;
import com.epul.projetsimulateurpistetoken.dto.Utilisateur;
import com.epul.projetsimulateurpistetoken.mesExceptions.MonException;
import com.epul.projetsimulateurpistetoken.repositories.EntityUtilisateurRepository;
import com.epul.projetsimulateurpistetoken.service.IUtilisateurService;
import com.epul.projetsimulateurpistetoken.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
    @Autowired
    private UtilisateurService unUtilisateurService;
    @GetMapping("/getUtil")
    public List<EntityUtilisateur> getAllUtilisateurs() {
        List<EntityUtilisateur> utilisateurs = unUtilisateurService.listerUtilisateurs();
        return utilisateurs;
    }

}
