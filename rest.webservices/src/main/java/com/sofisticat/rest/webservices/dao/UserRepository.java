package com.sofisticat.rest.webservices.dao;

import com.sofisticat.rest.webservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
