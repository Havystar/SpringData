package pl.lbd.jdbc.rowMapper;

import org.springframework.jdbc.core.RowMapper;
import pl.lbd.jdbc.entity.Address;
import pl.lbd.jdbc.entity.Staff;
import pl.lbd.jdbc.querryResult.StaffAddress;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffAddressMapper implements RowMapper {


    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        StaffAddress staffAddress = new StaffAddress();
        Address address = new Address();
        address.setAddressId(rs.getLong("address_id"));
        address.setAddress(rs.getString("address"));
        address.setAddress2(rs.getString("address2"));
        address.setDistrict(rs.getString("district"));
        address.setLastUpdate(null);
        address.setPhone(rs.getString("phone"));
        address.setPostalCode(rs.getString("postal_code"));
        staffAddress.setAddress(address);


        Staff staff = new Staff();
        staff.setStaffId(rs.getLong("staff_id"));
        staff.setEmail(rs.getString("email"));
        staff.setFirtName(rs.getString("firt_name"));
        staff.setLastName(rs.getString("last_name"));
       staffAddress.setStaff(staff);
       return staffAddress;
    }

}
