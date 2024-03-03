package campolina.hrgroup.hrapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import campolina.hrgroup.hrapp.model.UserInfo;
import campolina.hrgroup.hrapp.service.UserInfoService;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("{user}/{userId}")
    public UserInfo saveUserInfo(@RequestBody UserInfo userInfo, @PathVariable("user") String user, @PathVariable("userId") Long userId) {
        return userInfoService.saveUserInfo(userInfo, user, userId);
    }

    @GetMapping("/{userInfoId}")
    public UserInfo getUserInfoById(@PathVariable Long userInfoId) {
        return userInfoService.getUserInfoById(userInfoId);
    }

    @GetMapping
    public List<UserInfo> getAllUserInfo() {
        return userInfoService.getAllUserInfos();
    }

    @PutMapping("/{userInfoId}")
    public UserInfo updateAdditionalInfo(@RequestBody UserInfo userInfo,
            @PathVariable Long userInfoId) {
        return userInfoService.updateUserInfo(userInfo, userInfoId);
    }

    @DeleteMapping("/{userInfoId}")
    public String deleteUserInfo(@PathVariable Long userInfoId) {
        return userInfoService.deleteUserInfo(userInfoId);
    }
}

