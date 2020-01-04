package com.itimoshin.spring_cloud_mastering.auth.domain.client;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ClientRepository extends ReactiveCrudRepository<ClientEntity, Long> {

    @Query("select client.*" +
            "from oauth_client client " +
            "join scope_client sc on sc.client_id=client.id " +
            "join scope s on s.id=sc.scope_id " +
            "where client.client_name=:clientName ")
    Mono<ClientEntity> findByClientName(String clientName);
}
