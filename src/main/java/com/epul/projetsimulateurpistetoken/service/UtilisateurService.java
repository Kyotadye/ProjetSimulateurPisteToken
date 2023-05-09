package com.epul.projetsimulateurpistetoken.service;

import com.epul.projetsimulateurpistetoken.domains.EntityUtilisateur;
import com.epul.projetsimulateurpistetoken.mesExceptions.MonException;
import com.epul.projetsimulateurpistetoken.repositories.EntityUtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService implements IUtilisateurService {
    private EntityUtilisateurRepository unUtilRepository;

    // on initialise à travers le constructeur
    @Autowired
    public UtilisateurService(EntityUtilisateurRepository UtilisateurRepository) {
        this.unUtilRepository = UtilisateurRepository;
    }
    // on liste les séjours dans un format de type tableau
    @Override
    public List<EntityUtilisateur> listerUtilisateurs() {
        try {
            return unUtilRepository.findAll();
        } catch (Exception e) {

            throw  new MonException("Select", "Sql", e.getMessage());

        }
    }
}
