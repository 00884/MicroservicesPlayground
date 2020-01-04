package com.itimoshin.spring_cloud_mastering.auth.domain.grant_type;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface GrantTypeRepository extends R2dbcRepository<GrantTypeEntity, Long> {
    @Query("select gt.* " +
            "from grant_type_client gtc " +
            "join grant_type gt on gt.id=gtc.grant_type_id " +
            "where gtc.client_id=:clientId")
    Flux<GrantTypeEntity> findGrantTypesByClientId(Long clientId);
}
