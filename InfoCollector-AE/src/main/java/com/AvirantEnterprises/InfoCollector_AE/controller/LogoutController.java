package com.AvirantEnterprises.InfoCollector_AE.controller;

;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login"; // Redirect to login page
    }
}
