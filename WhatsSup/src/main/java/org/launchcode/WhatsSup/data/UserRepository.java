package org.launchcode.WhatsSup.data;
import org.launchcode.WhatsSup.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{
    User findByUsername(String username);
}

