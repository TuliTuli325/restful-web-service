package com.in28minutes.rest.webservices.restfulwebservice.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    //JPA/Hibernate Database
    //Static List
    private static List<User> users = new ArrayList<>();

    static int id_generate = 0;

    static {
        users.add(new User("Adam", ++id_generate, LocalDate.now().minusYears(30)));
        users.add(new User("Eve", ++id_generate, LocalDate.now().minusYears(25)));
        users.add(new User("Jim", ++id_generate, LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }
    //public User save(User user){
    public User findOne(int id){
    Predicate<? super User> predicate = user -> user.getId().equals(id);
	return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User createUser(User user) {
        user.setId(++id_generate);
        return user;
    }
}
