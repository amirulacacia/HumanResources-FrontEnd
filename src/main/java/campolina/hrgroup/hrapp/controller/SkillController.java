package campolina.hrgroup.hrapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import campolina.hrgroup.hrapp.model.Skill;
import campolina.hrgroup.hrapp.service.SkillService;

@RestController
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @PostMapping("{user}/{userId}")
    public Skill createSkill(@RequestBody Skill skill, @PathVariable("user") String user,
            @PathVariable("userId") Long userId) {
        return skillService.createSkill(skill, user, userId);
    }

    @GetMapping("/{skillId}")
    public Skill getSkillById(@PathVariable Long skillId) {
        return skillService.getSkillById(skillId);
    }

    @GetMapping
    public List<Skill> getAllSkills() {
        return skillService.getAllSkills();
    }

    @PutMapping("/{skillId}")
    public Skill updateSkill(@RequestBody Skill skill,
            @PathVariable Long skillId) {
        return skillService.updateSkill(skill, skillId);
    }

    @DeleteMapping("/{skillId}")
    public String deleteSkill(@PathVariable Long skillId) {
        return skillService.deleteSkill(skillId);
    }
}
