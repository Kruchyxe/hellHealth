package pl.kruchyxe.hellhealth.service;

import pl.kruchyxe.hellhealth.dto.CustomerDto;
import pl.kruchyxe.hellhealth.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer addCustomer(CustomerDto customerDto);

    List<CustomerDto> findAllCustomers();

    Optional<Customer> get(long id);

    void deleteCustomerById(long id);

    void updateCustomer(Customer customer);

}
