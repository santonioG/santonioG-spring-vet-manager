package com.duoc.veterinaria.repository;

import org.springframework.data.repository.CrudRepository;

import com.duoc.veterinaria.model.User;

// Esta interfaz permite realizar operaciones CRUD (Create, Read, Update, Delete)
public interface UserRepository extends CrudRepository<User, Long> {
    // Spring genera automáticamente la consulta SQL: SELECT * FROM users WHERE username = ?
    User findByUsername(String username);
}
