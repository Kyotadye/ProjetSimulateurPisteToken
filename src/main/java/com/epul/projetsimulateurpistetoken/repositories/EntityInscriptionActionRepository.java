package com.epul.projetsimulateurpistetoken.repositories;

import com.epul.projetsimulateurpistetoken.domains.EntityInscriptionAction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntityInscriptionActionRepository extends JpaRepository<EntityInscriptionAction, Integer>{
    List<EntityInscriptionAction> findByFkInscription(int inscriptionId);
}
