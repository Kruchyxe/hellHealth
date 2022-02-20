package pl.kruchyxe.hellhealth.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import pl.kruchyxe.hellhealth.dto.CustomerDto;
import pl.kruchyxe.hellhealth.model.Customer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.annotation.Documented;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer addCustomer(CustomerDto customerDto);

    List<CustomerDto> findAllCustomers();

    Optional<Customer> get(Long id);

    void deleteCustomerById(Long id);

    void updateCustomer(Customer customer);

    long countCustomer(Long id);



}


