package com.postgresql.java_tour_agenstvo.Repository;

import com.postgresql.java_tour_agenstvo.Tour.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Long> {
}
