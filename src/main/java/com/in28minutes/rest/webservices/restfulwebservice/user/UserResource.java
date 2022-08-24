package com.in28minutes.rest.webservices.restfulwebservice.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    private UserDaoService service;
    public UserResource(UserDaoService service){
        this.service = service;
    }
    //GET /users
    @GetMapping("/users")
    public List<User> RetrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User RetrieveUserById(@PathVariable Integer id){
        User user =  service.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id:" + id);
        }
        return user;
    }

    @PostMapping("/user")
    public ResponseEntity<Object> PostUser(@Valid @RequestBody User user){
        User savedUser = service.createUser(user);
        //当创建好新的user后，结果会被定向到/user/id页面中
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
