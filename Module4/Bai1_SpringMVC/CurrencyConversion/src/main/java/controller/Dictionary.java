package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
public class Dictionary {
    Map<String, String> dic = new HashMap<>();

    @GetMapping("/dictionary")
    public ModelAndView showFrom(){
        return new ModelAndView("dictionary");
    }

    @PostMapping("/dictionary")
    public ModelAndView dictionary(@RequestParam("language") String language){
        dic.put("Hi" , "Chao");
        dic.put("Dog" , "Cho");
        dic.put("Cat" , "Meo");
        dic.put("Main" , "Chinh");
        Set<String> keySet = dic.keySet();
        ModelAndView modelAndView = new ModelAndView("dictionary");
        for (String key: keySet) {
            if(key.equals(language)){
                modelAndView.addObject("Alert" , dic.get(key));
                break;
            } else {
                modelAndView.addObject("Alert" , "Not Found");
            }
        }
        return modelAndView;
    }
}
