package com.postgresql.java_tour_agenstvo.Service;


import com.postgresql.java_tour_agenstvo.Repository.TourRepository;
import com.postgresql.java_tour_agenstvo.Tour.Tour;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {
    private final TourRepository tourRepository;

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public List<Tour> getAllTours(){
        return tourRepository.findAll();
    }

    public Tour saveTour(Tour tour){
        return tourRepository.save(tour);
    }
}
