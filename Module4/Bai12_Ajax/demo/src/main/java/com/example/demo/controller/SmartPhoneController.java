package com.example.demo.controller;

import com.example.demo.model.SmartPhone;
import com.example.demo.service.ISmartphoneService;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartPhoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<SmartPhone> createSmartphone(@RequestBody SmartPhone smartPhone) {
        return new ResponseEntity<>(smartphoneService.save(smartPhone), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("phones/list");
        modelAndView.addObject("smartphones", smartphoneService.findAll());
        return modelAndView;
    }

    @GetMapping
    public ResponseEntity<Iterable<SmartPhone>> allPhone() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> deleteSmartPhone(@PathVariable Long id) {
        Optional<SmartPhone> smartPhone = smartphoneService.findById(id);
        if (!smartPhone.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartPhone.get(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ModelAndView getSmartphoneById(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("phones/edit");
        return modelAndView;
    }
}
