package com.epul.projetsimulateurpistetoken.service;

import com.epul.projetsimulateurpistetoken.domains.EntityUtilisateur;
import com.epul.projetsimulateurpistetoken.mesExceptions.MonException;
import com.epul.projetsimulateurpistetoken.repositories.EntityUtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public EntityUtilisateur getUtilById(int id) {
        try{
            return unUtilRepository.findByNumUtil(id);
        } catch (Exception e){
            throw new MonException("Select","sql",e.getMessage());
        }
    }

    public void ajouterUtilisateur(EntityUtilisateur unU){
        try{
        unUtilRepository.save(unU);
    }catch (MonException e){
            throw new MonException("Insert", "sql", e.getMessage());
        }
    }

    /*public void deleteUtilisateur(int id){
        try{
            unUtilRepository.deleteByNumUtil(id);
        }catch (MonException e){
            throw new MonException("Delete", "sql", e.getMessage());
        }
    }*/

    public void deleteUtilisateur(int id) throws MonException {
        try {
            Optional<EntityUtilisateur> utilisateurOptional = unUtilRepository.findById(id);
            if (utilisateurOptional.isPresent()) {
                unUtilRepository.deleteById(id);
            } else {
                throw new MonException("Delete", "sql", "Utilisateur non trouvé avec l'ID : " + id);
            }
        } catch (DataAccessException e) {
            throw new MonException("Delete", "sql", e.getMessage());
        }
    }

}
