package controller;

import model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import service.IProvinceService;

@Controller
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    IProvinceService provinceService;

    @GetMapping
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView("/province/list");
        modelAndView.addObject("provinces" , provinceService.findAll());
        return modelAndView;
    }

    @GetMapping("view/{id}")
    public ModelAndView viewCustomer(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("province/info");
        RestTemplate restTemplate = new RestTemplate();
        Province province = restTemplate.getForObject("http://localhost:8080/finById/" + id , Province.class);
        modelAndView.addObject("province" , province);
        return modelAndView;
    }
}
