CREATE TABLE actor
(
    actor_id    bigint NOT NULL,
    first_name  varchar(255),
    last_name   varchar(255),
    last_update timestamp,
    PRIMARY KEY (actor_id)
);

CREATE TABLE address
(
    address_id  bigint NOT NULL,
    address     varchar(255),
    address2    varchar(255),
    district    varchar(255),
    last_update timestamp,
    phone       varchar(255),
    postal_code varchar(255),
    city_id     bigint,
    PRIMARY KEY (address_id)
);

CREATE TABLE category
(
    category_id bigint NOT NULL,
    last_update date,
    name        varchar(255),
    PRIMARY KEY (category_id)
);

CREATE TABLE city
(
    city_id     bigint NOT NULL,
    city        varchar(255),
    last_update timestamp,
    country_id  bigint,
    PRIMARY KEY (city_id)
);

CREATE TABLE country
(
    country_id  bigint NOT NULL,
    country     varchar(255),
    last_update timestamp,
    PRIMARY KEY (country_id)
);

CREATE TABLE customer
(
    customer_id      bigint NOT NULL,
    active           boolean,
    activebool       boolean,
    create_date      timestamp,
    email            varchar(255),
    first_name       varchar(255),
    last_name        varchar(255),
    last_update      timestamp,
    address_id       bigint,
    rental_rental_id bigint,
    store_id         bigint,
    PRIMARY KEY (customer_id)
);

CREATE TABLE film
(
    film_id          bigint           NOT NULL,
    description      varchar(255),
    last_update      date,
    length           integer          NOT NULL,
    rating           varchar(255),
    release_year     date,
    rental_duration  integer          NOT NULL,
    rental_rate      double precision NOT NULL,
    replacement_cost double precision NOT NULL,
    special_features varchar(255),
    title            varchar(255),
    language_id      bigint,
    PRIMARY KEY (film_id)
);

CREATE TABLE film_actor
(
    actor_id    bigint NOT NULL,
    film_id     bigint NOT NULL,
    last_update timestamp,
    PRIMARY KEY (actor_id, film_id)
);

CREATE TABLE film_category
(
    category_id bigint NOT NULL,
    film_id     bigint NOT NULL,
    last_update date,
    PRIMARY KEY (category_id, film_id)
);

CREATE TABLE inventory
(
    inventory_id     bigint NOT NULL,
    last_update      date,
    film_film_id     bigint,
    rental_rental_id bigint,
    store_store_id   bigint,
    PRIMARY KEY (inventory_id)
);

CREATE TABLE language
(
    language_id bigint NOT NULL,
    last_update date,
    name        varchar(255),
    PRIMARY KEY (language_id)
);

CREATE TABLE payment
(
    payment_id   bigint NOT NULL,
    amount       double precision,
    payment_date timestamp,
    customer_id  bigint,
    rental_id    bigint,
    staff_id     bigint,
    PRIMARY KEY (payment_id)
);

CREATE TABLE rental
(
    rental_id            bigint NOT NULL,
    last_update          date,
    rental_date          date,
    return_date          date,
    customer_customer_id bigint,
    inventory_id         bigint,
    staff_id             bigint,
    PRIMARY KEY (rental_id)
);

CREATE TABLE staff
(
    staff_id       bigint NOT NULL,
    active         boolean,
    email          varchar(255),
    firt_name      varchar(255),
    last_name      varchar(255),
    last_update    date,
    password       varchar(255),
    picture        varchar(255),
    username       varchar(255),
    address_id     bigint,
    store_store_id bigint,
    PRIMARY KEY (staff_id)
);

CREATE TABLE store
(
    store_id                  bigint NOT NULL,
    last_upadte               timestamp,
    address_id                bigint,
    manager_staff_id_staff_id bigint,
    PRIMARY KEY (store_id)
);

ALTER TABLE address
    ADD FOREIGN KEY (city_id)
        REFERENCES city (city_id);

ALTER TABLE city
    ADD FOREIGN KEY (country_id)
        REFERENCES country (country_id);

ALTER TABLE customer
    ADD FOREIGN KEY (store_id)
        REFERENCES store (store_id);

ALTER TABLE customer
    ADD FOREIGN KEY (address_id)
        REFERENCES address (address_id);

ALTER TABLE customer
    ADD FOREIGN KEY (rental_rental_id)
        REFERENCES rental (rental_id);

ALTER TABLE film
    ADD FOREIGN KEY (language_id)
        REFERENCES language (language_id);

ALTER TABLE film_actor
    ADD FOREIGN KEY (film_id)
        REFERENCES film (film_id);

ALTER TABLE film_actor
    ADD FOREIGN KEY (actor_id)
        REFERENCES actor (actor_id);

ALTER TABLE film_category
    ADD FOREIGN KEY (category_id)
        REFERENCES category (category_id);

ALTER TABLE film_category
    ADD FOREIGN KEY (film_id)
        REFERENCES film (film_id);

ALTER TABLE inventory
    ADD FOREIGN KEY (film_film_id)
        REFERENCES film (film_id);

ALTER TABLE inventory
    ADD FOREIGN KEY (rental_rental_id)
        REFERENCES rental (rental_id);

ALTER TABLE inventory
    ADD FOREIGN KEY (store_store_id)
        REFERENCES store (store_id);

ALTER TABLE payment
    ADD FOREIGN KEY (rental_id)
        REFERENCES rental (rental_id);

ALTER TABLE payment
    ADD FOREIGN KEY (customer_id)
        REFERENCES customer (customer_id);

ALTER TABLE payment
    ADD FOREIGN KEY (staff_id)
        REFERENCES staff (staff_id);

ALTER TABLE rental
    ADD FOREIGN KEY (staff_id)
        REFERENCES staff (staff_id);

ALTER TABLE rental
    ADD FOREIGN KEY (inventory_id)
        REFERENCES inventory (inventory_id);

ALTER TABLE rental
    ADD FOREIGN KEY (customer_customer_id)
        REFERENCES customer (customer_id);

ALTER TABLE staff
    ADD FOREIGN KEY (store_store_id)
        REFERENCES store (store_id);

ALTER TABLE staff
    ADD FOREIGN KEY (address_id)
        REFERENCES address (address_id);

ALTER TABLE store
    ADD FOREIGN KEY (address_id)
        REFERENCES address (address_id);

ALTER TABLE store
    ADD FOREIGN KEY (manager_staff_id_staff_id)
        REFERENCES staff (staff_id);
