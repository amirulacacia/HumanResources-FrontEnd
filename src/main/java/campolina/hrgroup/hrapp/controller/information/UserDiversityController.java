package campolina.hrgroup.hrapp.controller.information;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import campolina.hrgroup.hrapp.model.information.UserDiversity;
import campolina.hrgroup.hrapp.service.information.UserDiversityService;

@RestController
@RequestMapping("/userDiversity")
public class UserDiversityController {

    @Autowired
    private UserDiversityService userDiversityService;

    @PostMapping("{user}/{userId}")
    public UserDiversity createUserDiversity(@RequestBody UserDiversity userDiversity,
            @PathVariable("user") String user, @PathVariable("userId") Long userId) {
        return userDiversityService.createUserDiversity(userDiversity, user, userId);
    }

    @GetMapping("/{userDiversityId}")
    public UserDiversity getUserDiversityById(@PathVariable Long userDiversityId) {
        return userDiversityService.getUserDiversityById(userDiversityId);
    }

    @GetMapping
    public List<UserDiversity> getAllUserDiversities() {
        return userDiversityService.getAllUserDiversities();
    }

    @PutMapping("/{userDiversityId}")
    public UserDiversity updateUserDiversity(@RequestBody UserDiversity userDiversity,
            @PathVariable Long userDiversityId) {
        return userDiversityService.updateUserDiversity(userDiversity, userDiversityId);
    }

    @DeleteMapping("/{userDiversityId}")
    public String deleteUserDiversity(@PathVariable Long userDiversityId) {
        return userDiversityService.deleteUserDiversity(userDiversityId);
    }
}
