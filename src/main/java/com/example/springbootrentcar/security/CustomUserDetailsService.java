package com.example.springbootrentcar.security;

import com.example.springbootrentcar.dto.UtenteDTO;
import com.example.springbootrentcar.entity.Utente;
import com.example.springbootrentcar.service.UtenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service("customUserDetailsService")
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UtenteService utenteService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Utente utente = utenteService.getUserByEmail(mail);
        if (utente == null) {
            throw new UsernameNotFoundException("Utente non trovato!");
        }
        User.UserBuilder builder = User.withUsername(utente.getEmail());
        builder.password(utente.getPassword());
        if (utente.isCustomer()) {
            builder.roles("USER");
        } else builder.roles("ADMIN");
        return builder.build();
    }
}
