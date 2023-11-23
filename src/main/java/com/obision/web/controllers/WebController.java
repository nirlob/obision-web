package com.obision.web.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.obision.web.beans.Contact;
import com.obision.web.models.Release;
import com.obision.web.repositories.ReleasesRepository;
import com.obision.web.services.MailService;

import java.time.LocalDate;
import java.util.List;

@Controller
public class WebController {

    private final ReleasesRepository releasesRepository;
    private final MailService mailService;

    public WebController(ReleasesRepository releasesRepository, MailService mailService) {
        this.releasesRepository = releasesRepository;
        this.mailService = mailService;
    }

    @GetMapping("/")
    public String index(Model model) {
        Release lastRelease = releasesRepository.findFirstByOrderByIdDesc();
        model.addAttribute("lastVersion", lastRelease.getVersion());
        model.addAttribute("sizeVersion", lastRelease.getSize());

        setCommonAttributes(model);
        return "index";
    }

    @GetMapping("/screenshots")
    public String screenshots(Model model) {
        setCommonAttributes(model);
        return "screenshots";
    }

    @GetMapping("/credits")
    public String credits(Model model) {
        setCommonAttributes(model);
        return "credits";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);

        setCommonAttributes(model);
        return "contact";
    }

    @GetMapping("/releases")
    public String releases(Model model) {
        List<Release> releases = releasesRepository.findAllByOrderByIdDesc();
        model.addAttribute("releases", releases);

        setCommonAttributes(model);
        return "releases";
    }

    @GetMapping("/install")
    public String install(Model model) {
        Release lastRelease = releasesRepository.findFirstByOrderByIdDesc();
        model.addAttribute("lastVersion", lastRelease.getVersion());

        setCommonAttributes(model);
        return "install";
    }

    @GetMapping("/documentation")
    public String documentation(Model model) {
        setCommonAttributes(model);
        return "documentation";
    }

    @GetMapping("/timeverse")
    public String timeverse(Model model) {
        return "timeverse";
    }

    @PostMapping("/contact")
    public String contactSubmit(@Valid Contact contact, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            if (mailService.sendMail(contact.getFrom(), contact.getSubject(), contact.getBody())) {
                model.addAttribute("success", "Contact data sent successfully");
                contact = new Contact();
            } else {
                model.addAttribute("error", "Error sending contact data");
            }
        }

        model.addAttribute("contact", contact);
        setCommonAttributes(model);
        return "contact";
    }

    private void setCommonAttributes(Model model) {
        model.addAttribute("year", LocalDate.now().getYear());
    }
}
