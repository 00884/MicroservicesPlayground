-- INSERT OAUTH CLIENTS
DO $$
    DECLARE
        _id BIGINT;
    BEGIN
        -- the passwords are "123456" encrypted wit BCrypt
        INSERT INTO oauth_client(client_name, client_secret) VALUES ('browser', '$2y$12$0006WD/UsVUUCpBeN.BVMeRXBc2Og/zea/UY0R0azJMu9TmVaZloS') RETURNING id INTO _id;
        INSERT INTO grant_type_client(client_id, grant_type_id) VALUES (_id, 1);
        INSERT INTO grant_type_client(client_id, grant_type_id) VALUES (_id, 2);
        INSERT INTO scope_client(scope_id, client_id) VALUES (1, _id);

        INSERT INTO oauth_client(client_name, client_secret) VALUES ('server', '$2y$12$0006WD/UsVUUCpBeN.BVMeRXBc2Og/zea/UY0R0azJMu9TmVaZloS') RETURNING id INTO _id;
        INSERT INTO grant_type_client(client_id, grant_type_id) VALUES (_id, 2);
        INSERT INTO grant_type_client(client_id, grant_type_id) VALUES (_id, 3);
        INSERT INTO scope_client(scope_id, client_id) VALUES (2, _id);
    END
$$;

-- INSERT USERS
DO $$
    DECLARE
        _id BIGINT;
    BEGIN
        -- the passwords are "111111" encrypted wit BCrypt
        INSERT INTO "user"(username, password) VALUES ('admin', '$2y$12$9dBPFenpWN3Z7Q3YSJVtj.3QiFFwRKZRhShR7yZbeu.yHVTs9oCWi') RETURNING id INTO _id;
        INSERT INTO user_role(user_id, role_id) VALUES (_id, 1);

        INSERT INTO "user"(username, password) VALUES ('user', '$2y$12$9dBPFenpWN3Z7Q3YSJVtj.3QiFFwRKZRhShR7yZbeu.yHVTs9oCWi') RETURNING id INTO _id;
        INSERT INTO user_role(user_id, role_id) VALUES (_id, 2);

    END
$$;
