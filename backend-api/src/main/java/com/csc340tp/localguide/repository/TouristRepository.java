package com.csc340tp.localguide.repository;

import com.csc340tp.localguide.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristRepository extends JpaRepository<Tourist, Long> {}
