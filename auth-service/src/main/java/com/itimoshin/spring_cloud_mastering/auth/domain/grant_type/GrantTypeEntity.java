package com.itimoshin.spring_cloud_mastering.auth.domain.grant_type;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("grant_type")
@NoArgsConstructor
@Data
public class GrantTypeEntity {

    @Id
    @Column("id")
    private Long id;

    @Column("name")
    private String name;
}
