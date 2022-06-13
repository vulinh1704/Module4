package com.codegym.controller;

import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @RequestMapping("/users")
    public String showUserList(Model model) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(0, "James" , "American" , "0"));
        userList.add(new User(1, "Linh" , "VietNam" , "1"));
        userList.add(new User(2, "Ken" , "Lao" , "2"));
        userList.add(new User(3, "Hung" , "Uc" , "0"));
        model.addAttribute("userList" , userList);
        return "variable-example";
    }
    @RequestMapping("/branch-example")
    public String branchExample(Model model){
        User user1 = new User(10, "Jimmy" , "LocalHost" , "1");
        User user2 = new User(11, "Hayden" , "SeverSide" , "2");
        User user3 = new User(12, "Envy" , "17.0.0.1" , "0");
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        model.addAttribute("users" , users);
        return "branch-example";
    }
}
