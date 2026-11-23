package com.careeragent.profile.controller;

import com.careeragent.profile.entity.Experience;
import com.careeragent.profile.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/profiles")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @PostMapping("/me/experiences")
    public ResponseEntity<String> create(
            @RequestBody Experience experience) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(experienceService.create(experience));
    }

    @GetMapping("/me/experiences")
    public ResponseEntity<List<Experience>> getAllExperience(){
        return ResponseEntity.ok(
                experienceService.getAllExperience());
    }

    @GetMapping("/me/experiences/{experienceId}")
    public ResponseEntity<Experience> getByExperienceId(
            @PathVariable Long experienceId) {
        return ResponseEntity.ok(
                experienceService.getById(experienceId));
    }

    @PutMapping("/me/experiences/{experienceId}")
    public ResponseEntity<String> update(
            @PathVariable Long experienceId,
            @RequestBody Experience experience) {

        return ResponseEntity.ok(
                experienceService.update(experienceId, experience)
        );
    }

    @DeleteMapping("/me/experiences/{experienceId}")
    public ResponseEntity<String> delete(
            @PathVariable Long experienceId) {

        return ResponseEntity.ok(
                experienceService.delete(experienceId));
    }

}
