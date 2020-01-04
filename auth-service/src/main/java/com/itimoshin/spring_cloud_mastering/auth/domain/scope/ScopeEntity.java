package com.itimoshin.spring_cloud_mastering.auth.domain.scope;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("scope")
@NoArgsConstructor
@Data
public class ScopeEntity {

    @Id
    @Column("id")
    private Long id;

    @Column("name")
    private String name;
}
