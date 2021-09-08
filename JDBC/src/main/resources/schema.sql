CREATE TABLE public.actor
(
    actor_id bigint NOT NULL,
    first_name varchar(255),
    last_name varchar(255),
    last_update timestamp,
    PRIMARY KEY (actor_id)
);

CREATE TABLE public.address
(
    id bigint NOT NULL,
    address varchar(255),
    address2 varchar(255),
    district varchar(255),
    last_update timestamp,
    phone varchar(255),
    postal_code varchar(255),
    city_id bigint,
    PRIMARY KEY (id)
);

CREATE TABLE public.category
(
    category_id bigint NOT NULL,
    last_update date,
    name varchar(255),
    PRIMARY KEY (category_id)
);

CREATE TABLE public.city
(
    id bigint NOT NULL,
    city varchar(255),
    last_update timestamp,
    country_id bigint,
    PRIMARY KEY (id)
);

CREATE TABLE public.country
(
    id bigint NOT NULL,
    country varchar(255),
    last_update timestamp,
    PRIMARY KEY (id)
);

CREATE TABLE public.customer
(
    customer_id bigint NOT NULL,
    active boolean,
    activebool boolean,
    create_date timestamp,
    email varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    last_update timestamp,
    address_id bigint,
    rental_rental_id bigint,
    store_id bigint,
    PRIMARY KEY (customer_id)
);

CREATE TABLE public.film
(
    film_id bigint NOT NULL,
    description varchar(255),
    last_update date,
    length integer NOT NULL,
    rating varchar(255),
    release_year date,
    rental_duration integer NOT NULL,
    rental_rate double precision NOT NULL,
    replacement_cost double precision NOT NULL,
    special_features varchar(255),
    title varchar(255),
    language_id bigint,
    PRIMARY KEY (film_id)
);

CREATE TABLE public.film_actor
(
    actor_id bigint NOT NULL,
    film_id bigint NOT NULL,
    last_update timestamp,
    PRIMARY KEY (actor_id, film_id)
);

CREATE TABLE public.film_category
(
    category_id bigint NOT NULL,
    film_id bigint NOT NULL,
    last_update date,
    PRIMARY KEY (category_id, film_id)
);

CREATE TABLE public.inventory
(
    inventory_id bigint NOT NULL,
    last_update date,
    film_film_id bigint,
    rental_rental_id bigint,
    store_store_id bigint,
    PRIMARY KEY (inventory_id)
);

CREATE TABLE public.language
(
    language_id bigint NOT NULL,
    last_update date,
    name varchar(255),
    PRIMARY KEY (language_id)
);

CREATE TABLE public.payment
(
    payment_id bigint NOT NULL,
    amount double precision,
    payment_date timestamp,
    customer_id bigint,
    rental_id bigint,
    staff_id bigint,
    PRIMARY KEY (payment_id)
);

CREATE TABLE public.rental
(
    rental_id bigint NOT NULL,
    last_update date,
    rental_date date,
    return_date date,
    customer_customer_id bigint,
    inventory_id bigint,
    staff_id bigint,
    PRIMARY KEY (rental_id)
);

CREATE TABLE public.staff
(
    staff_id bigint NOT NULL,
    active boolean,
    email varchar(255),
    firt_name varchar(255),
    last_name varchar(255),
    last_update date,
    password varchar(255),
    picture varchar(255),
    username varchar(255),
    address_id bigint,
    store_store_id bigint,
    PRIMARY KEY (staff_id)
);

CREATE TABLE public.store
(
    store_id bigint NOT NULL,
    last_upadte timestamp,
    address_id bigint,
    manager_staff_id_staff_id bigint,
    PRIMARY KEY (store_id)
);

ALTER TABLE public.address
    ADD FOREIGN KEY (city_id)
        REFERENCES public.city (id);

ALTER TABLE public.city
    ADD FOREIGN KEY (country_id)
        REFERENCES public.country (id);

ALTER TABLE public.customer
    ADD FOREIGN KEY (store_id)
        REFERENCES public.store (store_id);

ALTER TABLE public.customer
    ADD FOREIGN KEY (address_id)
        REFERENCES public.address (id);

ALTER TABLE public.customer
    ADD FOREIGN KEY (rental_rental_id)
        REFERENCES public.rental (rental_id);

ALTER TABLE public.film
    ADD FOREIGN KEY (language_id)
        REFERENCES public.language (language_id);

ALTER TABLE public.film_actor
    ADD FOREIGN KEY (film_id)
        REFERENCES public.film (film_id);

ALTER TABLE public.film_actor
    ADD FOREIGN KEY (actor_id)
        REFERENCES public.actor (actor_id);

ALTER TABLE public.film_category
    ADD FOREIGN KEY (category_id)
        REFERENCES public.category (category_id);

ALTER TABLE public.film_category
    ADD FOREIGN KEY (film_id)
        REFERENCES public.film (film_id);

ALTER TABLE public.inventory
    ADD FOREIGN KEY (film_film_id)
        REFERENCES public.film (film_id);

ALTER TABLE public.inventory
    ADD FOREIGN KEY (rental_rental_id)
        REFERENCES public.rental (rental_id);

ALTER TABLE public.inventory
    ADD FOREIGN KEY (store_store_id)
        REFERENCES public.store (store_id);

ALTER TABLE public.payment
    ADD FOREIGN KEY (rental_id)
        REFERENCES public.rental (rental_id);

ALTER TABLE public.payment
    ADD FOREIGN KEY (customer_id)
        REFERENCES public.customer (customer_id);

ALTER TABLE public.payment
    ADD FOREIGN KEY (staff_id)
        REFERENCES public.staff (staff_id);

ALTER TABLE public.rental
    ADD FOREIGN KEY (staff_id)
        REFERENCES public.staff (staff_id);

ALTER TABLE public.rental
    ADD FOREIGN KEY (inventory_id)
        REFERENCES public.inventory (inventory_id);

ALTER TABLE public.rental
    ADD FOREIGN KEY (customer_customer_id)
        REFERENCES public.customer (customer_id);

ALTER TABLE public.staff
    ADD FOREIGN KEY (store_store_id)
        REFERENCES public.store (store_id);

ALTER TABLE public.staff
    ADD FOREIGN KEY (address_id)
        REFERENCES public.address (id);

ALTER TABLE public.store
    ADD FOREIGN KEY (address_id)
        REFERENCES public.address (id);

ALTER TABLE public.store
    ADD FOREIGN KEY (manager_staff_id_staff_id)
        REFERENCES public.staff (staff_id);
