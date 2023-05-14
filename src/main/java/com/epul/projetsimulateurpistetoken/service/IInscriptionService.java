package com.epul.projetsimulateurpistetoken.service;

import com.epul.projetsimulateurpistetoken.domains.EntityInscription;
import com.epul.projetsimulateurpistetoken.repositories.EntityInscriptionRepository;

import java.util.List;

public interface IInscriptionService {

    //Méthodes
    List<EntityInscription> listerInscriptions();
}
