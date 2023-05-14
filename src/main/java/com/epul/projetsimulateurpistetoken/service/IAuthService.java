package com.epul.projetsimulateurpistetoken.service;

import com.epul.projetsimulateurpistetoken.dto.JwtResponse;
import com.epul.projetsimulateurpistetoken.dto.UtilisateurDto;

public interface IAuthService {

    JwtResponse authenticateUser(UtilisateurDto userDto);

    //JwtResponse createUser(Utilisateur userDto) throws AuthException;

}
