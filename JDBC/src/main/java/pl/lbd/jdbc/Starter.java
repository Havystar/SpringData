package pl.lbd.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import pl.lbd.jdbc.entity.*;
import pl.lbd.jdbc.querryResult.CustomerAddress;
import pl.lbd.jdbc.querryResult.StaffAddress;
import pl.lbd.jdbc.repository.ActorRepository;
import pl.lbd.jdbc.repository.CategoryRepository;
import pl.lbd.jdbc.repository.CustomerRepository;
import pl.lbd.jdbc.repository.FilmRepository;
import pl.lbd.jdbc.rowMapper.CustomerAddressMapper;
import pl.lbd.jdbc.rowMapper.StaffAddressMapper;
import pl.lbd.jdbc.service.FilmService;

import java.util.List;

@SpringBootApplication
public class Starter implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    FilmService filmService;
    @Override
    public void run(String... args) throws Exception {
        //outputs for tasks
        //Task 1
        List<Category> task1 = categoryRepository.listAllSorted();
        //Task 2
        Pageable paging = PageRequest.of(0, 20);
        List<Film> task2 = filmRepository.findAllByCategory("Horror",paging);
        //Task 3
        List<Film> task3 = filmRepository.findAllByLanguage("Polski");
        //Task 4
        List<Actor>task4=actorRepository.getAllActorsInFilm("Kiepscy");
        //Task 5
        String task5 = filmService.getStatus(1L);
        //Task 6
        List<Payment> task6 = customerRepository.getAllPaymentsById(1L);
        //Task 7
        CustomerAddress customerAddress=getCustomerInfo(1L);
        //Task 8
        List<StaffAddress> staffAddressList = getStaffsInfo();
        //Task 9
        List<Film> task9 = filmRepository.findAllByActorNameAndLastName("Andrzej","Kabala");
        //Task 10
        List<Rental>task10=customerRepository.getAllRentals(2L
                ,PageRequest.of(0,1,Sort.by(Sort.Order.asc("rental_date"))));


    }
       public  CustomerAddress getCustomerInfo(Long id)
       {
           CustomerAddress  customerAddress=
                   jdbcTemplate.queryForObject("select * from customer c join address a on c.address_id=a.address_id where customer_id=?"
                           ,new CustomerAddressMapper(),new Object[]{id});
            return customerAddress;
       }
    public List<StaffAddress> getStaffsInfo()
    {
        List<StaffAddress> staffAddresses=
                jdbcTemplate.query("select * from staff s join address a on s.address_id=a.address_id"
                        ,new StaffAddressMapper());
        return staffAddresses;
    }


}
