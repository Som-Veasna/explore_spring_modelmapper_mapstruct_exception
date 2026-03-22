CREATE TABLE IF NOT EXISTS addresses (
                                         id      SERIAL       PRIMARY KEY,
                                         street  VARCHAR(255) NOT NULL,
                                         city    VARCHAR(100) NOT NULL,
                                         country VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS app_users (
                                         id         SERIAL       PRIMARY KEY,
                                         username   VARCHAR(50)  NOT NULL UNIQUE,
                                         email      VARCHAR(100) NOT NULL UNIQUE,
                                         password   TEXT         NOT NULL,
                                         full_name  VARCHAR(100),
                                         address_id INT          REFERENCES addresses(id) ON DELETE SET NULL
);