package com.careeragent.profile.service;

import com.careeragent.profile.entity.Experience;
import com.careeragent.profile.entity.Profile;
import com.careeragent.profile.exception.CustomExceptions;
import com.careeragent.profile.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    public String create(Experience req) {
        experienceRepository.save(req);
        return "Experience information created successfully";
    }

    public List<Experience> getAllExperience() {
        return experienceRepository.findAll();
    }

    public Experience getById(Long experienceId) {

        return experienceRepository.findById(experienceId)
                .orElseThrow(() -> new CustomExceptions(
                        "Experience not found with ID: " + experienceId
                ));
    }

    public String update(Long experienceId, Experience req) {

        Experience experience = experienceRepository.findById(experienceId)
                .orElseThrow(() -> new CustomExceptions(
                        "Experience not found with ID: " + experienceId
                ));

        experience.setCompanyName(req.getCompanyName());
        experience.setJobTitle(req.getJobTitle());
        experience.setEmploymentType(req.getEmploymentType());
        experience.setLocation(req.getLocation());
        experience.setStartDate(req.getStartDate());
        experience.setEndDate(req.getEndDate());
        experience.setCurrentlyWorking(req.getCurrentlyWorking());
        experience.setJobDescription(req.getJobDescription());
        experience.setResponsibilities(req.getResponsibilities());
        experience.setTechnologiesUsed(req.getTechnologiesUsed());

        experienceRepository.save(experience);

        return "Experience updated successfully";
    }

    public String delete(Long experienceId) {

        Experience experience = experienceRepository.findById(experienceId)
                .orElseThrow(() -> new CustomExceptions(
                        "Experience not found with ID: " + experienceId
                ));
        experienceRepository.delete(experience);
        return "Experience deleted successfully";
    }
}