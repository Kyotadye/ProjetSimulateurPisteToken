package com.epul.projetsimulateurpistetoken.controller;

import com.epul.projetsimulateurpistetoken.domains.EntityUtilisateur;
import com.epul.projetsimulateurpistetoken.mesExceptions.MonException;
import com.epul.projetsimulateurpistetoken.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/ajout", method = RequestMethod.POST)
    public ResponseEntity ajoutUtilisateur(@RequestBody EntityUtilisateur unU)
            throws MonException, Exception {
        try {
            unUtilisateurService.ajouterUtilisateur(unU);
            return ResponseEntity.ok().build();
        } catch (MonException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {

            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable int id)
            throws MonException, Exception {
        try {
            unUtilisateurService.deleteUtilisateur(id);
            return ResponseEntity.ok().build();
        } catch (MonException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {

            return ResponseEntity.notFound().build();
        }
    }

}
