package com.epul.projetsimulateurpistetoken.service;

import com.epul.projetsimulateurpistetoken.domains.EntityUtilisateur;

import java.util.List;

public interface IUtilisateurService {
    // on liste les séjours dans un format de type tableau
    List<EntityUtilisateur> listerUtilisateurs();
}
