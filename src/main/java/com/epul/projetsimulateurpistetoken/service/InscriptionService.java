package com.epul.projetsimulateurpistetoken.service;

import com.epul.projetsimulateurpistetoken.domains.EntityAction;
import com.epul.projetsimulateurpistetoken.domains.EntityInscription;
import com.epul.projetsimulateurpistetoken.domains.EntityInscriptionAction;
import com.epul.projetsimulateurpistetoken.mesExceptions.MonException;
import com.epul.projetsimulateurpistetoken.repositories.EntityInscriptionActionRepository;
import com.epul.projetsimulateurpistetoken.repositories.EntityInscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InscriptionService implements IInscriptionService {
    private EntityInscriptionRepository uneInscriptionRepository;
    private EntityInscriptionActionRepository uneInscriptionActionRepository;

    //Constructeur
    @Autowired
    public InscriptionService(EntityInscriptionRepository unEntityInscriptionRepository,
                              EntityInscriptionActionRepository uneInscriptionActionRepository) {
        this.uneInscriptionRepository = unEntityInscriptionRepository;
        this.uneInscriptionActionRepository = uneInscriptionActionRepository;
    }

    //Méthodes
    @Override
    public List<EntityInscription> listerInscriptions() {
        try{
            return uneInscriptionRepository.findAll();
        } catch (Exception e){
            throw new MonException("Select","sql",e.getMessage());
        }
    }

    public List<EntityInscription> listerInscriptionsById(int id) {
        try{
            return uneInscriptionRepository.findByFkUser(id);
        } catch (Exception e){
            throw new MonException("Select","sql",e.getMessage());
        }
    }

    public List<EntityAction> getActionsByInscription(int inscriptionId) {
        List<EntityAction> actions = new ArrayList<>();

        List<EntityInscriptionAction> inscriptionActions = uneInscriptionActionRepository.findByFkInscription(inscriptionId);
        for (EntityInscriptionAction inscriptionAction : inscriptionActions) {
            EntityAction action = inscriptionAction.getActionByFkAction();
            actions.add(action);
        }

        return actions;
    }

}
