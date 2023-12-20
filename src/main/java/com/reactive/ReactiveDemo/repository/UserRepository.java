package com.reactive.ReactiveDemo.repository;

import com.reactive.ReactiveDemo.modal.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
@Repository
public interface UserRepository extends R2dbcRepository<User, Integer> {
}
