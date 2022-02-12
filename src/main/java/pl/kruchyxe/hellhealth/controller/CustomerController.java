package pl.kruchyxe.hellhealth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kruchyxe.hellhealth.dto.CustomerDto;
import pl.kruchyxe.hellhealth.model.Customer;
import pl.kruchyxe.hellhealth.service.CustomerService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;

    }

    @GetMapping()
    public String customerList(Model model) {
        model.addAttribute("customer", customerService.findAllCustomers());
        return "customer/customers";
    }

    @GetMapping("/addcustomer")
    public String showAddCustomerForm(Model model) {
        model.addAttribute("customer", new CustomerDto());
        return "customer/addcustomer";
    }

    @PostMapping("/addcustomer")
    public String addNewCustomer(@Valid @ModelAttribute("customer") CustomerDto customerDto,
                                 BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            return "customer/addcustomer";
        }
        customerService.addCustomer(customerDto);
        return "redirect:/customers";
    }

    @GetMapping("/deletecustomer")
    public String deleteStudent(long id){
        customerService.deleteCustomerById(id);
        return "redirect:/customers";
    }

    @GetMapping("/detailscustomer")
    public String showDetailForm(long id, Model model) {
        model.addAttribute("customer", customerService.get(id)
                .orElseThrow(EntityNotFoundException::new));
        return "customer/detailscustomer";
    }

    @GetMapping("/editscustomer")
    public String showEditForm(long id, Model model) {
        model.addAttribute("customer", customerService.get(id));
        return "customer/editscustomer";
    }

    @PostMapping("/editscustomer")
    public String editCustomer(@Valid Customer customer, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "customer/editscustomer";
        }
        customerService.updateCustomer(customer);
        return "redirect:/customers";
    }


}
