package com.epul.projetsimulateurpistetoken.repositories;

import com.epul.projetsimulateurpistetoken.domains.EntityUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntityUtilisateurRepository extends JpaRepository<EntityUtilisateur, Integer> {

    //public EntityUtilisateur findByNomUtil(String login);

    Optional<EntityUtilisateur> findByNomUtil(String username);

    public List<EntityUtilisateur> findAll();
    public EntityUtilisateur findByNumUtil(int id);

    public void deleteByNumUtil(int id);


}

