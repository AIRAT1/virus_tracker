package de.virus_tracker.controller;

import de.virus_tracker.service.VirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    VirusDataService virusDataService;

    @Autowired
    public HomeController(VirusDataService virusDataService) {
        this.virusDataService = virusDataService;
    }

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("locationStatistics", virusDataService.getAllStats());
        return mav;
    }
}
