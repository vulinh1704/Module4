package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CurrencyConversionController {
    @GetMapping("/currencyConversion")
    public ModelAndView showForm(){
        return new ModelAndView("index");
    }

    @PostMapping("/currencyConversion")
    public ModelAndView conversion(@RequestParam int USD){
        ModelAndView modelAndView = new ModelAndView("index");
        int VND = USD * 23000;
        modelAndView.addObject("VND" , VND);
        return modelAndView;
    }
}
