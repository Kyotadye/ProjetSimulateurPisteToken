package com.epul.projetsimulateurpistetoken.repositories;

import com.epul.projetsimulateurpistetoken.domains.EntityUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityUtilisateurRepository extends JpaRepository<EntityUtilisateur, Integer> {

    public EntityUtilisateur findByNomUtil(String login);
}

