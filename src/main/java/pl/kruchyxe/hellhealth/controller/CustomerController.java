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
        return "customers";
    }

    @GetMapping("/addcustomers")
    public String showAddCustomerForm(Model model) {
        model.addAttribute("customer", new CustomerDto());
        return "addcustomer";
    }

    @PostMapping("/addcustomers")
    public String addNewCustomer(@Valid @ModelAttribute("customer") CustomerDto customerDto,
                                 BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            return "addcustomer";
        }
        customerService.addCustomer(customerDto);
        return "redirect:/customers";
    }

    @GetMapping("/deletecustomer")
    public String deleteStudent(int id){
        customerService.deleteCustomerById(id);
        return "redirect:/customers";
    }

    @GetMapping("/detailscustomer")
    public String showDetailForm(int id, Model model) {
        model.addAttribute("customer", customerService.get(id)
                .orElseThrow(EntityNotFoundException::new));
        return "detailscustomer";
    }

    @GetMapping("/editcustomer")
    public String showEditForm(int id, Model model) {
        model.addAttribute("customer", customerService.get(id));
        return "editcustomer";
    }

    @PostMapping("/editcustomer")
    public String editCustomer(@Valid Customer customer, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "editcustomer";
        }
        customerService.updateCustomer(customer);
        return "redirect:/customers";
    }


}
