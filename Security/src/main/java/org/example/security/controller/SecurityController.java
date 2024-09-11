package org.example.security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping("/login-page")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/welcome-page")
    public String welcomePage(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("User: " + auth.getName());
        System.out.println("Roles: " + auth.getAuthorities());
       System.out.println(request.getSession().getId());
        return "success";
    }

}

