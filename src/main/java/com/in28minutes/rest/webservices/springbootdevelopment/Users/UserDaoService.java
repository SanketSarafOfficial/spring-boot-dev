package com.in28minutes.rest.webservices.springbootdevelopment.Users;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//This will be where we will do fetching thing , This will be our component class
// This will be used to perform some operations in database
//Component file
@Component
public class UserDaoService {
// here we wil use this to retrieve details of all user , save user data and retrieve any particular user data.
// JPA & Hibernate will be used to talk to the database.

    // Lets create a static list of users

    private static int userCount = 0;

    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User(++userCount, "Sanket", LocalDate.now().minusYears(24)));
        users.add(new User(++userCount, "Gyanshu", LocalDate.now().minusYears(27)));
        users.add(new User(++userCount, "Bhibhu", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount, "Shubham", LocalDate.now().minusYears(34)));
        users.add(new User(++userCount, "Souvik", LocalDate.now().minusYears(67)));
    }

    //retrieve all users info
    public List<User> findAll() {
        return users;
    }

    //retrieve info of a particular user

    public User findOne(Integer id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User userSave(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public void deleteById(Integer id) {
      Predicate <? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
