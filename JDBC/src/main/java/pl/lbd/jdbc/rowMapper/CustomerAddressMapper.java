package pl.lbd.jdbc.rowMapper;

import org.springframework.jdbc.core.RowMapper;
import pl.lbd.jdbc.entity.Address;
import pl.lbd.jdbc.entity.Customer;
import pl.lbd.jdbc.querryResult.CustomerAddress;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomerAddressMapper implements RowMapper<CustomerAddress> {
    @Override
    public CustomerAddress mapRow(ResultSet rs, int rowNum) throws SQLException {

        CustomerAddress customerAddress = new CustomerAddress();
        Address address = new Address();
        address.setAddressId(rs.getLong("address_id"));
        address.setAddress(rs.getString("address"));
        address.setAddress2(rs.getString("address2"));
        address.setDistrict(rs.getString("district"));
        address.setLastUpdate(null);
        address.setPhone(rs.getString("phone"));
        address.setPostalCode(rs.getString("postal_code"));
        customerAddress.setAddress(address);


        Customer customer = new Customer();
        customer.setCustomer_id(rs.getLong("customer_id"));
        customer.setEmail(rs.getString("email"));
        customer.setFirstName(rs.getString("first_name"));
        customer.setLastName(rs.getString("last_name"));
        customerAddress.setCustomer(customer);
        return customerAddress;




    }
}
