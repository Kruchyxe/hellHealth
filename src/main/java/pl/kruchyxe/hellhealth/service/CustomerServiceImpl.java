package pl.kruchyxe.hellhealth.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pl.kruchyxe.hellhealth.dto.CustomerDto;
import pl.kruchyxe.hellhealth.model.Customer;
import pl.kruchyxe.hellhealth.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;


    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(CustomerDto customerDto) {
        Customer student = new Customer(customerDto.getFirstName(), customerDto.getLastName(), customerDto.getGender(),
                customerDto.getAge(), customerDto.getWeight(), customerDto.getHeight());
        return customerRepository.save(student);
    }

    @Override
    public List<CustomerDto> findAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> customersDto = StreamSupport
                .stream(customers.spliterator(), false).map(customer -> {
                    CustomerDto dto = new CustomerDto();
                    BeanUtils.copyProperties(customer, dto);
                    return dto;
                })
                .collect(Collectors.toList());
        return customersDto;
    }

    @Override
    public Optional<Customer> get(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);

    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);

    }

    @Override
    public long countCustomer(Long id) {
        return customerRepository.count();
    }
}
