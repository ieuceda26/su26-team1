package com.csc340tp.localguide.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csc340tp.localguide.entity.Guide;
import com.csc340tp.localguide.service.GuideService;

@RestController
@RequestMapping("/api/guides")
public class GuideController {
    private final GuideService guideService;

  public GuideController(GuideService guideService) {
    this.guideService = guideService;
  }

  @GetMapping
  public ResponseEntity<List<Guide>> getAllGuides() {
    List<Guide> guides = guideService.getAllGuides();
    if (guides.isEmpty()) {
      return ResponseEntity.ok(Collections.emptyList());
    }
    return ResponseEntity.ok(guides);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Guide> getGuideById(@PathVariable long id) {
    Guide guide = guideService.getGuideById(id);
    if (guide != null) {
      return ResponseEntity.ok(guide);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<Guide> createGuide(@RequestBody Guide guide) {
    Guide createdGuide = guideService.createGuide(guide);
    return ResponseEntity.ok(createdGuide);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Guide> updateGuide(@PathVariable long id, @RequestBody Guide updatedGuide) {
    Guide guide = guideService.updateGuide(id, updatedGuide);
    if (guide != null) {
      return ResponseEntity.ok(guide);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteGuide(@PathVariable long id) {
    boolean deleted = guideService.deleteGuide(id);
    if (deleted) {
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/search")
  public ResponseEntity<List<Guide>> searchGuides(@RequestParam String query) {
    List<Guide> guides = guideService.searchGuides(query);
    if (guides.isEmpty()) {
      return ResponseEntity.ok(Collections.emptyList());
    }
    return ResponseEntity.ok(guides);
  }

  @GetMapping("/keyword-search")
  public ResponseEntity<List<Guide>> searchGuidesByKeyword(@RequestParam String keyword) {
    List<Guide> guides = guideService.searchGuidesByKeyword(keyword);
    if (guides.isEmpty()) {
      return ResponseEntity.ok(Collections.emptyList());
    }
    return ResponseEntity.ok(guides);
  }

}
