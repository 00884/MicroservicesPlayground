CREATE TABLE scope(
 id BIGINT PRIMARY KEY,
 name TEXT NOT NULL
);

CREATE TABLE grant_type(
  id BIGINT PRIMARY KEY,
  name TEXT NOT NULL
);

CREATE TABLE oauth_client(
  id BIGSERIAL PRIMARY KEY,
  client_name TEXT NOT NULL,
  client_secret TEXT NOT NULL
);

CREATE TABLE grant_type_client(
    grant_type_id BIGINT REFERENCES grant_type(id),
    client_id BIGINT REFERENCES oauth_client(id),
    PRIMARY KEY (grant_type_id, client_id)
);

CREATE TABLE scope_client(
    scope_id BIGINT REFERENCES scope(id),
    client_id BIGINT REFERENCES oauth_client(id),
    PRIMARY KEY (scope_id, client_id)
);

CREATE TABLE "role" (
    id BIGINT PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE "user" (
    id BIGSERIAL PRIMARY KEY,
    username TEXT NOT NULL,
    password TEXT NOT NULL
);

CREATE TABLE user_role (
    user_id BIGINT REFERENCES "user"(id),
    role_id BIGINT REFERENCES "role"(id),
    PRIMARY KEY (user_id, role_id)
)
