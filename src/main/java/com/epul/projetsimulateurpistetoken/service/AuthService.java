package com.epul.projetsimulateurpistetoken.service;

import com.epul.projetsimulateurpistetoken.config.jwt.JwtTokenUtils;
import com.epul.projetsimulateurpistetoken.config.service.UserDetailsImpl;
import com.epul.projetsimulateurpistetoken.dto.JwtResponse;
import com.epul.projetsimulateurpistetoken.dto.UtilisateurDto;
import com.epul.projetsimulateurpistetoken.repositories.EntityUtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService implements IAuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private EntityUtilisateurRepository userRepository;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Override
    public JwtResponse authenticateUser(UtilisateurDto userDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.getNomUtil(), userDto.getMotPasse()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        return new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                roles);
    }

}
