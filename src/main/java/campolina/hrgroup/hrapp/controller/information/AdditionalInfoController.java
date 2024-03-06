package campolina.hrgroup.hrapp.controller.information;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import campolina.hrgroup.hrapp.model.information.AdditionalInfo;
import campolina.hrgroup.hrapp.service.information.AdditionalInfoService;

import java.util.List;

@RestController
@RequestMapping("/additionalInfo")
public class AdditionalInfoController {

    @Autowired
    private AdditionalInfoService additionalInfoService;

    @PostMapping("{user}/{userId}")
    public AdditionalInfo createAdditionalInfo(@RequestBody AdditionalInfo additionalInfo,
            @PathVariable("user") String user, @PathVariable("userId") Long userId) {
        return additionalInfoService.createAdditionalInfo(additionalInfo, user, userId);
    }

    @GetMapping("/{additionalInfoId}")
    public AdditionalInfo getAdditionalInfoById(@PathVariable Long additionalInfoId) {
        return additionalInfoService.getAdditionalInfoById(additionalInfoId);
    }

    @GetMapping
    public List<AdditionalInfo> getAllAdditionalInfo() {
        return additionalInfoService.getAllAdditionalInfo();
    }

    @PutMapping("/{additionalInfoId}")
    public AdditionalInfo updateAdditionalInfo(@RequestBody AdditionalInfo additionalInfo,
            @PathVariable Long additionalInfoId) {
        return additionalInfoService.updateAdditionalInfo(additionalInfo, additionalInfoId);
    }

    @DeleteMapping("/{additionalInfoId}")
    public String deleteAdditionalInfo(@PathVariable Long additionalInfoId) {
        return additionalInfoService.deleteAdditionalInfo(additionalInfoId);
    }
}
