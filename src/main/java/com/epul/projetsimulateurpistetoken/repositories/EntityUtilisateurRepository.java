package com.epul.projetsimulateurpistetoken.repositories;

import com.epul.projetsimulateurpistetoken.domains.EntityUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntityUtilisateurRepository extends JpaRepository<EntityUtilisateur, Integer> {

    public EntityUtilisateur findByNomUtil(String login);

    public List<EntityUtilisateur> findAll();
}

