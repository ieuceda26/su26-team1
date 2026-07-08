package com.csc340tp.localguide.repository;

import com.csc340tp.localguide.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
    List<Tour> findByTouristTouristId(Long touristId);
}

