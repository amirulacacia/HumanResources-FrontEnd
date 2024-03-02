package campolina.hrgroup.hrapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import campolina.hrgroup.hrapp.model.UserInfo;
import campolina.hrgroup.hrapp.service.UserInfoService;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping
    public UserInfo saveUserInfo(@RequestBody UserInfo userInfo) {
        return userInfoService.saveUserInfo(userInfo);
    }

    @GetMapping("/{id}")
    public UserInfo getUserInfoById(@PathVariable Long id) {
        return userInfoService.getUserInfoById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUserInfo(@PathVariable Long id) {
        return userInfoService.deleteUserInfo(id);
    }
}

