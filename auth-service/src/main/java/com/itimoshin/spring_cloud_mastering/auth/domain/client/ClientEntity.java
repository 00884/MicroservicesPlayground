package com.itimoshin.spring_cloud_mastering.auth.domain.client;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("oauth_client")
@Data
public class ClientEntity {

    @Id
    @Column("id")
    private Long id;

    @Column("client_name")
    private String clientName;

    @Column("client_secret")
    private String clientSecret;
}
