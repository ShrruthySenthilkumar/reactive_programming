package com.reactive.ReactiveDemo.controller;

import com.reactive.ReactiveDemo.modal.User;
import com.reactive.ReactiveDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController

@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public Flux<User> getAllUsers(@RequestParam(required = false) String name) {

            return userService.findAll();

    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<User> getUserById(@PathVariable("id") int id) {
        return userService.findById(id);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> createUsers(@RequestBody User user) {
        return userService.save(new User(user.getName(), user.getJob_description(), user.isFull_time_employee()));
    }

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<User> updateUsers(@PathVariable("id") int id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteUsers(@PathVariable("id") int id) {
        return userService.deleteById(id);
    }

    @DeleteMapping("/Users")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAllUsers() {
        return userService.deleteAll();
    }

}
