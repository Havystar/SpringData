package pl.lbd.jdbc.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertData() {
        jdbcTemplate.execute("INSERT INTO actor( actor_id, first_name, last_name, last_update) VALUES (1,'Jerzy','ASDASDAS', null)");
        jdbcTemplate.execute("INSERT INTO actor( actor_id, first_name, last_name, last_update) VALUES (2,'Andrzej','Kabala', null)");
        jdbcTemplate.execute("INSERT INTO actor( actor_id, first_name, last_name, last_update) VALUES (3,'Piotrek','ESESESE', null)");

        jdbcTemplate.execute(" INSERT INTO category( category_id, last_update, name) VALUES (1,current_timestamp(2),'Wielkie')");
        jdbcTemplate.execute(" INSERT INTO category( category_id, last_update, name) VALUES (2,current_timestamp(2),'Horror')");
        jdbcTemplate.execute(" INSERT INTO category( category_id, last_update, name) VALUES (3,current_timestamp(2),'Dramat')");

        jdbcTemplate.execute("INSERT INTO language( language_id, last_update, name) VALUES (1,current_timestamp(2),'Polski')");
        jdbcTemplate.execute("INSERT INTO language( language_id, last_update, name) VALUES (2,current_timestamp(2),'Angielski')");
        jdbcTemplate.execute("INSERT INTO language( language_id, last_update, name) VALUES (3,current_timestamp(2),'Niemiecki')");

        jdbcTemplate.execute(" INSERT INTO film( film_id, description, last_update, length, rating, release_year, rental_duration, rental_rate, replacement_cost, special_features, title, language_id) VALUES (1,'XD',current_timestamp(2),20,'G',current_timestamp(2),20,20,20,'XD','Kiepscy',1)");
        jdbcTemplate.execute(" INSERT INTO film( film_id, description, last_update, length, rating, release_year, rental_duration, rental_rate, replacement_cost, special_features, title, language_id) VALUES (2,'XD',current_timestamp(2),20,'G',current_timestamp(2),20,20,20,'XD','Wielki Potwor',1)");
        jdbcTemplate.execute(" INSERT INTO film( film_id, description, last_update, length, rating, release_year, rental_duration, rental_rate, replacement_cost, special_features, title, language_id) VALUES (3,'XD',current_timestamp(2),20,'G',current_timestamp(2),20,20,20,'XD','Tytanic',1)");

        jdbcTemplate.execute("INSERT INTO film_category( category_id, film_id, last_update) VALUES (1,1, current_timestamp(2))");
        jdbcTemplate.execute("INSERT INTO film_category( category_id, film_id, last_update) VALUES (2,1, current_timestamp(2))");
        jdbcTemplate.execute("INSERT INTO film_category( category_id, film_id, last_update) VALUES (3,1, current_timestamp(2))");

        jdbcTemplate.execute("INSERT INTO film_actor( actor_id, film_id, last_update) VALUES (1, 1, current_timestamp(2))");
        jdbcTemplate.execute("INSERT INTO film_actor( actor_id, film_id, last_update) VALUES (2, 2, current_timestamp(2))");
        jdbcTemplate.execute("INSERT INTO film_actor( actor_id, film_id, last_update) VALUES (3, 3, current_timestamp(2))");

        jdbcTemplate.execute("INSERT INTO country( country_id, country, last_update) VALUES (1,'Serbia',current_timestamp(2))");
        jdbcTemplate.execute("INSERT INTO country( country_id, country, last_update) VALUES (2,'Bosnia',current_timestamp(2))");
        jdbcTemplate.execute("INSERT INTO country( country_id, country, last_update) VALUES (3,'Czechy',current_timestamp(2))");

        jdbcTemplate.execute("INSERT INTO city( city_id, city, last_update, country_id) VALUES (1,'Gliwice',current_timestamp(2),1)");
        jdbcTemplate.execute("INSERT INTO city( city_id, city, last_update, country_id) VALUES (2,'Zabrze',current_timestamp(2),2)");
        jdbcTemplate.execute("INSERT INTO city( city_id, city, last_update, country_id) VALUES (3,'Katowice',current_timestamp(2),3)");

        jdbcTemplate.execute("INSERT INTO address( address_id, address, address2, district, last_update, phone, postal_code, city_id) VALUES (1,'Zeromskiego','test','dystryk9',null,'12341234','444-4',1)");
        jdbcTemplate.execute("INSERT INTO address( address_id, address, address2, district, last_update, phone, postal_code, city_id) VALUES (2,'Bytomska','test','dystryk1',null,'12341234','444-4',1)");
        jdbcTemplate.execute("INSERT INTO address( address_id, address, address2, district, last_update, phone, postal_code, city_id) VALUES (3,'Katowicka','test','dystryk2',null,'12341234','444-4',1)");

        jdbcTemplate.execute("INSERT INTO staff( staff_id, active, email, firt_name, last_name, last_update, password, picture, username, address_id, store_id) VALUES (1,true,'EASDAS@gmail.com','Tomek','Tomek',null,'es','easdasd','esses',1,null)");
        jdbcTemplate.execute("INSERT INTO staff( staff_id, active, email, firt_name, last_name, last_update, password, picture, username, address_id, store_id) VALUES (2,true,'EASDAS@gmail.com','jerzy','Kicha',null,'es','easdasd','esses',1,null)");
        jdbcTemplate.execute("INSERT INTO staff( staff_id, active, email, firt_name, last_name, last_update, password, picture, username, address_id, store_id) VALUES (3,true,'EASDAS@gmail.com','Puotrek','Wojt',null,'es','easdasd','esses',1,null)");

        jdbcTemplate.execute("INSERT INTO store( store_id, last_upadte, address_id, manager_staff_id) VALUES (1,null,1,1)");
        jdbcTemplate.execute("INSERT INTO store( store_id, last_upadte, address_id, manager_staff_id) VALUES (2,null,2,2)");
        jdbcTemplate.execute("INSERT INTO store( store_id, last_upadte, address_id, manager_staff_id) VALUES (3,null,3,3)");

        jdbcTemplate.execute("INSERT INTO customer( customer_id, active, activebool, create_date, email, first_name, last_name, last_update, address_id, rental_id, store_id) VALUES (1,null,null,null,'ASDASDASD@Gmail.com','Jerzy','Kabala',null,1,null,1)");
        jdbcTemplate.execute("INSERT INTO customer( customer_id, active, activebool, create_date, email, first_name, last_name, last_update, address_id, rental_id, store_id) VALUES (2,null,null,null,'ASDASDASD@Gmail.com','Tomek','EASDAS',null,2,null,1)");
        jdbcTemplate.execute("INSERT INTO customer( customer_id, active, activebool, create_date, email, first_name, last_name, last_update, address_id, rental_id, store_id) VALUES (3,null,null,null,'ASDASDASD@Gmail.com','Piotrek','Tomla',null,3,null,1)");

        jdbcTemplate.execute("INSERT INTO inventory( inventory_id, last_update, film_id, rental_id, store_id) VALUES (1,null,1,null,1)");
        jdbcTemplate.execute("INSERT INTO inventory( inventory_id, last_update, film_id, rental_id, store_id) VALUES (2,null,2,null,2)");
        jdbcTemplate.execute("INSERT INTO inventory( inventory_id, last_update, film_id, rental_id, store_id) VALUES (3,null,3,null,3)");

        jdbcTemplate.execute("INSERT INTO rental( rental_id, last_update, rental_date, return_date, customer_id, inventory_id, staff_id) VALUES (1,null,null,null,2,1,1)");
        jdbcTemplate.execute("INSERT INTO rental( rental_id, last_update, rental_date, return_date, customer_id, inventory_id, staff_id) VALUES (2,null,null,null,2,2,2)");
        jdbcTemplate.execute("INSERT INTO rental( rental_id, last_update, rental_date, return_date, customer_id, inventory_id, staff_id) VALUES (3,null,null,null,3,3,3)");

        jdbcTemplate.execute("INSERT INTO payment( payment_id, amount, payment_date, customer_id, rental_id, staff_id) VALUES (1,205.15,null,1,1,1)");
        jdbcTemplate.execute("INSERT INTO payment( payment_id, amount, payment_date, customer_id, rental_id, staff_id) VALUES (2,205.15,null,2,2,2)");
        jdbcTemplate.execute("INSERT INTO payment( payment_id, amount, payment_date, customer_id, rental_id, staff_id) VALUES (3,205.15,null,3,3,3)");


    }

    @EventListener({ContextRefreshedEvent.class})
    void seedData() {
        insertData();
    }
}
