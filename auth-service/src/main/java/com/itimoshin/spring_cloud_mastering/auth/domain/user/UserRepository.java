package com.itimoshin.spring_cloud_mastering.auth.domain.user;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends R2dbcRepository<UserEntity, Long> {
    @Query("select * from \"user\" where username=:username")
    Mono<UserEntity> findByUsername(String username);
}
