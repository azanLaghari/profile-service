package com.careeragent.profile.service;

import com.careeragent.profile.entity.Profile;
import com.careeragent.profile.entity.Skill;
import com.careeragent.profile.exception.CustomExceptions;
import com.careeragent.profile.repository.ProfileRepository;
import com.careeragent.profile.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public String create(Long profileId, Skill skill) {

        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new CustomExceptions(
                        "Profile not found with ID: " + profileId
                ));

        skill.setProfile(profile);

        skillRepository.save(skill);

        return "Skill information created successfully";
    }

    public List<Skill> getAllSkills(Long profileId) {

        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new CustomExceptions(
                        "Profile not found with ID: " + profileId
                ));

        return skillRepository.findByProfile(profile);
    }

    public Skill getByIdSkillId(Long skillId) {
        return skillRepository.findById(skillId)
                .orElseThrow(() -> new CustomExceptions(
                        "Skill not found with skillId: " + skillId
                ));
    }

    public Skill update(Long skillId, Skill req) {

        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new CustomExceptions(
                        "Skill not found with skillId: " + skillId
                ));

        skill.setSkillName(req.getSkillName());
        skill.setSkillCategory(req.getSkillCategory());
        skill.setProficiencyLevel(req.getProficiencyLevel());
        skill.setYearsOfExperience(req.getYearsOfExperience());

        return skillRepository.save(skill);
    }

    public String delete(Long skillId) {

        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new CustomExceptions(
                        "Skill not found with skillId: " + skillId
                ));

        skillRepository.delete(skill);

        return "Skill deleted successfully";
    }

    public String deleteAll(Long profileId) {

        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new CustomExceptions(
                        "Profile not found with profileId: " + profileId
                ));

        skillRepository.deleteByProfileProfileId(profileId);

        return "All skills deleted successfully";
    }
}
