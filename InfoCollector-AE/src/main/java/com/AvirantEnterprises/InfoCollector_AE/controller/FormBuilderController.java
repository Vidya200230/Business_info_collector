package com.AvirantEnterprises.InfoCollector_AE.controller;
import com.AvirantEnterprises.InfoCollector_AE.model.Form;
import com.AvirantEnterprises.InfoCollector_AE.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class FormBuilderController {
    @Autowired
    private FormRepository formRepository;
    @GetMapping("/formBuilder")
    public String formBuilder(Model model){
        model.addAttribute("form", new Form());
        return "formBuilder";
    }
    @GetMapping("/saveForm")
    public String saveForm(@ModelAttribute("form") Form form){
        formRepository.save(form);
        return "redirect:/forms";
    }
    @GetMapping("/forms")
    public String showForms(Model model){
        model.addAttribute("forms", formRepository.findAll());
        return "forms";
    }
}
