package pl.kruchyxe.hellhealth.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pl.kruchyxe.hellhealth.dto.CustomerDto;
import pl.kruchyxe.hellhealth.model.Customer;
import pl.kruchyxe.hellhealth.repository.CustomerRepository;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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

    public static ByteArrayInputStream customerPDFReport(List<Customer> customers) {

        Document document = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, outputStream);
            document.open();

            com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
            Paragraph paragraph = new Paragraph("Customers List", font);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(7);

//            Stream.of("id", "first name", "last name", "age", "gender", "height", "weight").forEach(header-> {
//                    PdfPCell header = new PdfPCell();
//                    com.itextpdf.text.Font headFont = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
//                    header.setBackgroundColor(BaseColor.BLACK);
//                    header.setHorizontalAlignment(Element.ALIGN_CENTER);
//                    header.setBorderWidth(1);
//                    header.setPhrase(new Phrase(headerId, headFont));
//                    table.addCell(header);
//            });
            for (Customer cust :customers){
                PdfPCell idCell = new PdfPCell(new Phrase(cust.getId()));
                idCell.setPaddingLeft(1);
                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                idCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(idCell);

                PdfPCell nameCell = new PdfPCell(new Phrase(cust.getFirstName()));
                nameCell.setPaddingLeft(1);
                nameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                nameCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(nameCell);

                PdfPCell lastNameCell = new PdfPCell(new Phrase(cust.getLastName()));
                lastNameCell.setPaddingLeft(1);
                lastNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                lastNameCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(lastNameCell);

                // need to finish rest of the data



            }
            document.add(table);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(outputStream.toByteArray());
    }
}
