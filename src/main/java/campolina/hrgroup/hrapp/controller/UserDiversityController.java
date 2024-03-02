package campolina.hrgroup.hrapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import campolina.hrgroup.hrapp.model.UserDiversity;
import campolina.hrgroup.hrapp.service.UserDiversityService;

@RestController
@RequestMapping("/userDiversity")
public class UserDiversityController {

    @Autowired
    private UserDiversityService userDiversityService;

    @PostMapping
    public UserDiversity createUserDiversity(@RequestBody UserDiversity userDiversity) {
        return userDiversityService.createUserDiversity(userDiversity);
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
        return userDiversityService.updateUserDiversity(userDiversity);
    }

    @DeleteMapping("/{userDiversityId}")
    public String deleteUserDiversity(@PathVariable Long userDiversityId) {
        return userDiversityService.deleteUserDiversity(userDiversityId);
    }
}

