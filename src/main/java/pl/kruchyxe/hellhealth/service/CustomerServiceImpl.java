package pl.kruchyxe.hellhealth.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
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

    private final ModelMapper mapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper mapper) {
        this.customerRepository = customerRepository;
        this.mapper = mapper;
    }

    private CustomerDto convertEntityToDto(Customer customer) {
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        CustomerDto customerDto;
        customerDto = mapper.map(customer, CustomerDto.class);
        return customerDto;
    }

    private Customer convertDtoToEntity(CustomerDto customerDto) {
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Customer customer;
        customer = mapper.map(customerDto, Customer.class);
        return customer;
    }

    @Override
    public Customer addCustomer(CustomerDto customerDto) {
        Customer customer = convertDtoToEntity(customerDto);
        return customerRepository.save(customer);
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
    public Optional<Customer> get(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void deleteCustomerById(int id) {
        customerRepository.deleteById(id);

    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);

    }
}
