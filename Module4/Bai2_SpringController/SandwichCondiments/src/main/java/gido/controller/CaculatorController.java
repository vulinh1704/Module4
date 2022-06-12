package gido.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CaculatorController {
    @GetMapping("/caculator")
    public ModelAndView showForm(){
        return new ModelAndView("caculator");
    }
    @PostMapping("/caculator")
    public ModelAndView caculator(@RequestParam("number1") int number1 , @RequestParam("number2") int number2 , @RequestParam("operator") String operator){
        ModelAndView modelAndView = new ModelAndView("caculator");
        int result = 0;
        if(operator.equals("Addition(+)")){
            result = number1 + number2;
            modelAndView.addObject("operator" , operator);
            modelAndView.addObject("result" , result);
            return modelAndView;
        }
        if (operator.equals("Subtraction(-)")){
            result = number1 - number2;
            modelAndView.addObject("operator" , operator);
            modelAndView.addObject("result" , result);
            return modelAndView;
        }
        if (operator.equals("Multiplication(X)")){
            result = number1 * number2;
            modelAndView.addObject("operator" , operator);
            modelAndView.addObject("result" , result);
            return modelAndView;
        }
        if (operator.equals("Division(/)")) {
            result = number1 / number2;
            modelAndView.addObject("operator" , operator);
            modelAndView.addObject("result" , result);
            return modelAndView;
        }
        return modelAndView;
    }
}
