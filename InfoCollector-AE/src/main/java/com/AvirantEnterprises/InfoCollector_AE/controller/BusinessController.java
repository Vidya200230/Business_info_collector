package com.AvirantEnterprises.InfoCollector_AE.controller;

import com.AvirantEnterprises.InfoCollector_AE.model.BusinessEntity;
import com.AvirantEnterprises.InfoCollector_AE.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    // User dashboard: Show the form to submit business details
    @GetMapping("/userDashboard")
    public String userDashboard(Model model) {
        // Retrieve the logged-in user’s submitted business forms (if any)
        model.addAttribute("businessForms", businessService.getBusinessFormsForUser());
        return "newBusiness";  // This renders the userDashboard.html
    }

    // Admin dashboard: Show all business forms submitted by users
    @GetMapping("/adminDashboard")
    public String adminDashboard(Model model) {

        // Retrieve all business forms submitted
        model.addAttribute("businessForms", businessService.getAllBusinessForms());
        return "admin_view_business";  // This renders the adminDashboard.html
    }

    // Display the business form to submit
    @GetMapping("/businessForm")
    public String showBusinessForm() {
        return "businessForm";  // This renders the form (businessForm.html)
    }

    // Handle business form submission
    @PostMapping("/submitBusinessForm")
    public String submitBusinessForm(@ModelAttribute BusinessEntity businessEntity, Model model) {
        // Save the business form to the database
        businessService.saveBusiness(businessEntity);

        // Add the businessEntity object to the model for Thymeleaf to access it
        model.addAttribute("business", businessEntity);

        // Redirect to the Thank You page
        return "thankYou";  // Redirects to thankYou.html
    }

    // Admin: Delete a business form
    @GetMapping("/deleteBusiness/{id}")
    public String deleteBusiness(@PathVariable Long id) {
        businessService.deleteBusiness(id);
        return "redirect:/adminDashboard";  // Redirect back to admin dashboard
    }
}
