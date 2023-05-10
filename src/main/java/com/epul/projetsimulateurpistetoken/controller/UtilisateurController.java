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
import org.springframework.web.bind.annotation.PathVariable;
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
        List<EntityUtilisateur> utilisateurs = null;
        try {
            utilisateurs = unUtilisateurService.listerUtilisateurs();
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        }
        return utilisateurs;
    }

    @GetMapping("/getUtil/{id}")
    public EntityUtilisateur getUtilById(@PathVariable(value = "id") int id) {
        EntityUtilisateur unEntityUtil = null;
        try {
            unEntityUtil = unUtilisateurService.getUtilById(id);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return unEntityUtil;
    }


}
