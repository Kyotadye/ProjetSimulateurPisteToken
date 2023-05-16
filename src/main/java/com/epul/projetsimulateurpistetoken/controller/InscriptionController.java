package com.epul.projetsimulateurpistetoken.controller;

import com.epul.projetsimulateurpistetoken.domains.EntityAction;
import com.epul.projetsimulateurpistetoken.domains.EntityInscription;
import com.epul.projetsimulateurpistetoken.domains.EntityInscriptionAction;
import com.epul.projetsimulateurpistetoken.mesExceptions.MonException;
import com.epul.projetsimulateurpistetoken.service.InscriptionService;
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
@RequestMapping("/inscription")
public class InscriptionController {
    @Autowired
    private InscriptionService uneInscriptionService;

    //Méthodes
    //Trouver les inscriptions d'un client
    @GetMapping("/getInscription")
    public List<EntityInscription> getAllInscription() {
        List<EntityInscription> inscriptions = null;
        try{
            inscriptions = uneInscriptionService.listerInscriptions();
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return inscriptions;
    }

    //Trouver les inscriptions d'un client
    @GetMapping("/getInscription/{id}")
    public List<EntityInscription> getInscriptionById(@PathVariable(value = "id") int id) {
        List<EntityInscription> inscriptions = null;
        try{
            inscriptions = uneInscriptionService.listerInscriptionsById(id);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return inscriptions;
    }

    @GetMapping("/{inscriptionId}/actions")
    public List<EntityAction> getInscriptionActions(@PathVariable (value="inscriptionId") int inscriptionId) {
        List<EntityAction> actions = null;
        try{
            actions = uneInscriptionService.getActionsByInscription(inscriptionId);
        } catch (MonException e) {
            ResponseEntity.notFound().build();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return actions;
    }
}
