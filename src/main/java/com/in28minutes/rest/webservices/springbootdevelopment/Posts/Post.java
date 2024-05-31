package com.in28minutes.rest.webservices.springbootdevelopment.Posts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.in28minutes.rest.webservices.springbootdevelopment.Users.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Integer Id;


    private String description;

    @ManyToOne(fetch = FetchType.LAZY) // sirf user load hoga , post load nahi hoga
    @JsonIgnore // since we don't want these details in response
    private User user;

    public Post(){
        super();
    }

    public Post(Integer id, String description) {
        Id = id;
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PostsFeature{" +
                "Id=" + Id +
                ", description='" + description + '\'' +
                '}';
    }
}
