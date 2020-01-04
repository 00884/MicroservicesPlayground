package com.itimoshin.spring_cloud_mastering.auth.domain.role;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface RoleRepository extends R2dbcRepository<RoleEntity, Long> {
    @Query("select r.*" +
            "from \"user\" u " +
            "join user_role ur on ur.user_id=u.id " +
            "join role r on r.id=ur.role_id " +
            "where u.id=:userId ")
    Flux<RoleEntity> findRolesByUserId(Long userId);
}
