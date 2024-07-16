package com.example.th_customer_manager.controllers;

import com.example.th_customer_manager.models.Customer;
import com.example.th_customer_manager.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping()
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showInformation(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("infor");
        Customer customer = customerService.findById(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
    @PostMapping("/update")
    public String updateCustomer(@RequestParam Long id,
                                 @RequestParam String name,
                                 @RequestParam String email,
                                 @RequestParam String address,
                                    Model model) {

        Customer customer = new Customer(id, name, email, address);
        customerService.save(customer);
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers",customers);
        return "list";
    }
}
