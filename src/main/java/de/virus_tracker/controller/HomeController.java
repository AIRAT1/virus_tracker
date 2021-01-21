package de.virus_tracker.controller;

import de.virus_tracker.models.Location;
import de.virus_tracker.service.VirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    VirusDataService virusDataService;

    @Autowired
    public HomeController(VirusDataService virusDataService) {
        this.virusDataService = virusDataService;
    }

    @GetMapping("/")
    public ModelAndView home() {
        List<Location> allStats = virusDataService.getAllStats();
        int totalCasesWorldwide = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDelta()).sum();
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("locationStatistics", allStats);
        mav.addObject("totalCasesWorldwide", totalCasesWorldwide);
        mav.addObject("totalNewCases", totalNewCases);
        return mav;
    }
}
