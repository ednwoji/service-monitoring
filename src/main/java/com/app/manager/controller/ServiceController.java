package com.app.manager.controller;

import com.app.manager.entity.AppsEntity;
import com.app.manager.entity.Availability;
import com.app.manager.repository.AppEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class ServiceController {

    @Autowired
    private AppEntityRepository serviceRepository;

    @GetMapping("/services")
    public String getServices(Model model) {
        model.addAttribute("services", serviceRepository.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        AppsEntity entity = new AppsEntity();
        entity.setUrlStatus(false);
        model.addAttribute("service", entity);
        return "add";
    }

    @PostMapping("/add")
    public String addService(@ModelAttribute AppsEntity service, RedirectAttributes redirectAttributes) {
        log.info("Incoming request is::: "+service.toString());
        service.setAvailability(Availability.OFFLINE);
        serviceRepository.save(service);
        redirectAttributes.addFlashAttribute("status", "Record saved successfully");
        return "redirect:/services";
    }

}
