package com.careeragent.profile.controller;

import com.careeragent.profile.entity.Skill;
import com.careeragent.profile.service.SkillService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/profiles")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @PostMapping("/me/skills/{profileId}")
    public ResponseEntity<String> create(
            @PathVariable Long profileId,
            @RequestBody Skill skill) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(skillService.create(profileId, skill));
    }

    @GetMapping("/me/skill/{profileId}")
    public ResponseEntity<List<Skill>> getAllSkills(
            @PathVariable Long profileId) {

        return ResponseEntity.ok(
                skillService.getAllSkills(profileId));
    }

    @GetMapping("/me/skills/{skillId}")
    public ResponseEntity<Skill> getBySkillId(
            @PathVariable Long skillId) {

        return ResponseEntity.ok(
                skillService.getByIdSkillId(skillId));
    }

    @PutMapping("/me/skills/{skillId}")
    public ResponseEntity<Skill> update(
            @PathVariable Long skillId,
            @RequestBody Skill skill) {

        return ResponseEntity.ok(
                skillService.update(skillId, skill));
    }

    @DeleteMapping("/me/skills/{skillId}")
    public ResponseEntity<String> delete(
            @PathVariable Long skillId) {

        return ResponseEntity.ok(
                skillService.delete(skillId));
    }

    @Transactional
    @DeleteMapping("/{profileId}/skills")
    public ResponseEntity<String> deleteAll(
            @PathVariable Long profileId) {

        return ResponseEntity.ok(
                skillService.deleteAll(profileId)
        );
    }
}
