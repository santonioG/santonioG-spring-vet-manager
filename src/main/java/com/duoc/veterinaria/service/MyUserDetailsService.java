package com.duoc.veterinaria.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.duoc.veterinaria.model.User;
import com.duoc.veterinaria.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Intentando login para: " + username); // Debug
        User user = userRepository.findByUsername(username);
        if (user == null) {
            System.out.println("Usuario no encontrado en la BD"); // Debug
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
        System.out.println("Usuario encontrado, clave en BD: " + user.getPassword()); // Debug
        return user;
    }

}
