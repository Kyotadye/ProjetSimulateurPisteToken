package com.epul.projetsimulateurpistetoken.config;

import com.epul.projetsimulateurpistetoken.domains.EntityUtilisateur;
import com.epul.projetsimulateurpistetoken.repositories.EntityUtilisateurRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final EntityUtilisateurRepository userRepository;

    public UserDetailsServiceImpl(EntityUtilisateurRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EntityUtilisateur user = userRepository.findByNomUtil(username);
        if (user == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé");
        }

        // Retourne un objet UserDetails basé sur les informations de l'utilisateur
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getNomUtil())
                .password(user.getMotPasse())
                .authorities(Collections.emptyList())
                .build();
    }
}

