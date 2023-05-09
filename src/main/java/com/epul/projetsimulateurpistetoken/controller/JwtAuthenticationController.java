package com.epul.projetsimulateurpistetoken.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/authentification")
@RestController
@CrossOrigin
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
        try {
            // Créer une instance de UsernamePasswordAuthenticationToken avec les informations d'identification fournies
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            // Authentifier l'utilisateur
            Authentication authentication = authenticationManager.authenticate(token);
            // Définir l'authentification dans le contexte de sécurité
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // Rediriger vers la page principale ou faire toute autre logique de redirection nécessaire
            return "eh beh";
        } catch (AuthenticationException e) {
            // Gérer l'échec de l'authentification, par exemple, rediriger vers une page d'erreur ou afficher un message d'erreur
            return "c chaud";
        }
    }
}
