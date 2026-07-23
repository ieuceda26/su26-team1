package com.csc340tp.localguide.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csc340tp.localguide.entity.Guide;

@Repository
public interface GuideRepository extends JpaRepository<Guide, Long> {
    List<Guide> findByNameContainingIgnoreCase(String nameKeyword);
    
    List<Guide> findByKeywordContainingIgnoreCase(String keyword);

    Guide findByEmail(String emailKeyword);
}
