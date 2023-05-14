package com.epul.projetsimulateurpistetoken.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.epul.projetsimulateurpistetoken.domains.EntityInscription;

import java.util.List;

@Repository
public interface EntityInscriptionRepository extends JpaRepository<EntityInscription, Integer>{
    public List<EntityInscription> findAll();

    public List<EntityInscription> findByFkUser(int id);

}
