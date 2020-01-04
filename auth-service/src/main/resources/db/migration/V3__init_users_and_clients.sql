-- INSERT OAUTH CLIENTS
DO $$
    DECLARE
        _id BIGINT;
    BEGIN
        INSERT INTO oauth_client(client_name, client_secret) VALUES ('browser', '123456') RETURNING id INTO _id;
        INSERT INTO grant_type_client(client_id, grant_type_id) VALUES (_id, 1);
        INSERT INTO grant_type_client(client_id, grant_type_id) VALUES (_id, 2);
        INSERT INTO scope_client(scope_id, client_id) VALUES (1, _id);

        INSERT INTO oauth_client(client_name, client_secret) VALUES ('server', '123456') RETURNING id INTO _id;
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
        -- the passwords are "111111"
        INSERT INTO "user"(username, password) VALUES ('admin', 'bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a') RETURNING id INTO _id;
        INSERT INTO user_role(user_id, role_id) VALUES (_id, 1);

        INSERT INTO "user"(username, password) VALUES ('user', 'bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a') RETURNING id INTO _id;
        INSERT INTO user_role(user_id, role_id) VALUES (_id, 2);

    END
$$;
