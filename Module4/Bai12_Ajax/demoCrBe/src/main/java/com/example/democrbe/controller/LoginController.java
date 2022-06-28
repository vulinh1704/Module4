package com.example.democrbe.controller;

import com.example.democrbe.model.User;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
@RequestMapping("/api/users")
public class LoginController {
    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @RequestMapping("/login")
    public ResponseEntity<User> Index(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("cookieValue", cookie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("dologin")
    public String doLogin(@ModelAttribute("user") User user, Model model, @CookieValue(value = "setUser", defaultValue = "") String setUser,
                          HttpServletResponse response, HttpServletRequest request) {
        if (user.getEmail().equals("admin@gmail.com") && user.getPassWord().equals("12345")) {
            if (user.getEmail() != null) {
                setUser = user.getEmail();
            }
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);

            Cookie[] cookies = request.getCookies();
            for (Cookie ck : cookies) {
                if (ck.getName().equals("setUser")) {
                    model.addAttribute("cookieValue", ck);
                    break;
                } else {
                    ck.setValue("");
                    model.addAttribute("cookieValue", ck);
                }
            }
            model.addAttribute("message", "Login success . Welcom ");
        } else {
            user.setEmail("");
            Cookie cookie = new Cookie("setUser", setUser);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message", "Login Failed , Try Again");
        }
        return "/login";
    }
}
