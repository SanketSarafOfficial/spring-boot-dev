package com.in28minutes.rest.webservices.springbootdevelopment.jpa;

import com.in28minutes.rest.webservices.springbootdevelopment.Posts.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {

}
