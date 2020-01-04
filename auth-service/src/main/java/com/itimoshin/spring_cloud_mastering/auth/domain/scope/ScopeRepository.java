package com.itimoshin.spring_cloud_mastering.auth.domain.scope;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ScopeRepository extends R2dbcRepository<ScopeEntity, Long> {
    @Query("select s.* " +
            "from scope_client sc " +
            "join scope s on s.id=sc.scope_id " +
            "where sc.client_id=:clientId")
    Flux<ScopeEntity> findScopesByClientId(Long clientId);
}
