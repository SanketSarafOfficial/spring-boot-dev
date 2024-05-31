package com.in28minutes.rest.webservices.springbootdevelopment.jpa;

import com.in28minutes.rest.webservices.springbootdevelopment.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
