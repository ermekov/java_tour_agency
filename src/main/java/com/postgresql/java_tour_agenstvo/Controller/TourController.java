package com.postgresql.java_tour_agenstvo.Controller;


import com.postgresql.java_tour_agenstvo.Repository.TourRepository;
import com.postgresql.java_tour_agenstvo.Service.TourService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TourController {

    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/tours")
    public String tours(Model model) {
        model.addAttribute("tours", tourService.getAllTours());
        return "tours";
    }

}
