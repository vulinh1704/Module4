package com.codegym.controller;

import com.codegym.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {
    @RequestMapping("/demo")
    public ModelAndView demo() {
        ModelAndView modelAndView = new ModelAndView("/demo");
        String name = "CodeGym";
        modelAndView.addObject("name", name);
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(1L, "CodeGym Ha Noi"));
        customerList.add(new Customer(2L, "CodeGym Da Nang"));
        customerList.add(new Customer(3L, "CodeGym Viet Tri"));
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }
}
