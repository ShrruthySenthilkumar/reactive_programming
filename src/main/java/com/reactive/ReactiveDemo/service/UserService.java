package com.reactive.ReactiveDemo.service;

import com.reactive.ReactiveDemo.modal.User;
import com.reactive.ReactiveDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    public Mono<User> findById(int id) {

        return userRepository.findById(id);
    }

    public Mono<User> save(User tutorial) {
        return userRepository.save(tutorial);
    }

    public Mono<User> update(int id, User user) {
        return userRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalTutorial -> {
                    if (optionalTutorial.isPresent()) {
                        user.setId(id);
                        return userRepository.save(user);
                    }

                    return Mono.empty();
                });
    }

    public Mono<Void> deleteById(int id) {
        return userRepository.deleteById(id);
    }

    public Mono<Void> deleteAll() {
        return userRepository.deleteAll();
    }


}
