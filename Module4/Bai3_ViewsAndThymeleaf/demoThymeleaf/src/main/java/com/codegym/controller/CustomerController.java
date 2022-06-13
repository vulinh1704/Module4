package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @RequestMapping("/conditional-operator-example")
    public String operatorExample() {
        return "conditional-operator-example";
    }

    @RequestMapping("/basic-operator-example")
    public String operatorExample2() {
        return "basic-operator-example";
    }

    @RequestMapping("/logic-operator-example")
    public String operatorExample3() {
        return "logic-operator-example";
    }

    private final ICustomerService customerService = new CustomerService();

    @GetMapping("/customer")
    public String index(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "/index";
    }

    @GetMapping("/customer/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/customer/save")
    public String save(Customer customer) {
        customer.setId((long) (Math.random() * 10000));
        customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("customer/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "edit";
    }

    @PostMapping("/customer/update")
    public String update(Customer customer) {
        customerService.update(Math.toIntExact(customer.getId()), customer);
        return "redirect:/customer";
    }

    @GetMapping("customer/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "delete";
    }

    @PostMapping("customer/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.remove(Math.toIntExact(customer.getId()));
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("customer/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "view";
    }

    @PostMapping("customer/search")
    public String search(@RequestParam String name ,RedirectAttributes redirect) {
        if (name != null) {
            List<Customer> customerListSearch = customerService.findByName(name);
            redirect.addFlashAttribute("customerListSearch", customerListSearch);
        }
        return "redirect:/customer";
    }
}
