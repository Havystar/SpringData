package pl.lbd.jdbc.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertData() {
        jdbcTemplate.execute("INSERT INTO actor( actor_id, first_name, last_name, last_update) VALUES (1,Jerzy,ASDASDAS, null)");
        jdbcTemplate.execute("INSERT INTO actor( actor_id, first_name, last_name, last_update) VALUES (2,Andrzej,Kabala, null)");
        jdbcTemplate.execute("INSERT INTO actor( actor_id, first_name, last_name, last_update) VALUES (3,Piotrek,ESESESE, null)");

        jdbcTemplate.execute("INSERT INTO address( address_id, address, address2, district, last_update, phone, postal_code, city_id) VALUES (1,Zeromskiego,test,dystryk9,null,12341234,444-4,1);");
        jdbcTemplate.execute("INSERT INTO address( address_id, address, address2, district, last_update, phone, postal_code, city_id) VALUES (2,Bytomska,test,dystryk1,null,12341234,444-4,1);");
        jdbcTemplate.execute("INSERT INTO address( address_id, address, address2, district, last_update, phone, postal_code, city_id) VALUES (3,Katowicka,test,dystryk2,null,12341234,444-4,1\n);");
    }
}
