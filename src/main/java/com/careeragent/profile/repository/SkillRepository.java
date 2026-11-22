package com.careeragent.profile.repository;
import com.careeragent.profile.entity.Profile;
import com.careeragent.profile.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    List<Skill> findByProfile(Profile profile);

    void deleteByProfileProfileId(Long profileId);
}
