package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.Upload;
import com.codegym.service.UploadFileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {
    @RequestMapping("/demo")
    public ModelAndView demo() {
        ModelAndView modelAndView = new ModelAndView("demo");
        String name = "CodeGym";
        modelAndView.addObject("name", name);
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(1L, "CodeGym Ha Noi"));
        customerList.add(new Customer(2L, "CodeGym Da Nang"));
        customerList.add(new Customer(3L, "CodeGym Viet Tri"));
        modelAndView.addObject("customerList", customerList);
        modelAndView.addObject("upload" ,new Upload());
        return modelAndView;
    }

    @PostMapping("upload")
    public ModelAndView upload( Upload upload) throws IOException {
        ModelAndView modelAndView = new ModelAndView("view");
        UploadFileService uploadFileService = new UploadFileService();
        uploadFileService.uploadFile(upload.getFile());
        return modelAndView;
    }
}
