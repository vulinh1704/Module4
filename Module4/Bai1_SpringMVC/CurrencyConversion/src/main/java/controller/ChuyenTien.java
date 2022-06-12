package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChuyenTien {
    @GetMapping("/chuyentien")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("chuyentien");
        return modelAndView;
    }
    @PostMapping("/chuyentien")
    public ModelAndView chuyenTien(@RequestParam("usd") int usd ){
        ModelAndView modelAndView = new ModelAndView("chuyentien");
        int vnd = usd * 23000;
        modelAndView.addObject("vnd" , vnd);
        return modelAndView;
    }
}
