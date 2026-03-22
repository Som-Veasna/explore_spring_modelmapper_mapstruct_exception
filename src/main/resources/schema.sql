CREATE TABLE IF NOT EXISTS app_users (
                                         id          SERIAL          PRIMARY KEY,
                                         username    VARCHAR(50)     NOT NULL,
    email       VARCHAR(100)    NOT NULL,
    password    TEXT            NOT NULL,
    full_name   VARCHAR(100)
    );