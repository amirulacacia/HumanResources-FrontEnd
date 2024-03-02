package campolina.hrgroup.hrapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import campolina.hrgroup.hrapp.model.AdditionalInfo;
import campolina.hrgroup.hrapp.service.AdditionalInfoService;
import java.util.List;

@RestController
@RequestMapping("/additionalinfo")
public class AdditionalInfoController {

    @Autowired
    private AdditionalInfoService additionalInfoService;

    @PostMapping
    public AdditionalInfo createAdditionalInfo(@RequestBody AdditionalInfo additionalInfo) {
        return additionalInfoService.createAdditionalInfo(additionalInfo);
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
    public AdditionalInfo updateAdditionalInfo(@RequestBody AdditionalInfo additionalInfo, @PathVariable Long additionalInfoId) {
        additionalInfo.setAdditionInfoId(additionalInfoId);
        return additionalInfoService.updateAdditionalInfo(additionalInfo);
    }

    @DeleteMapping("/{additionalInfoId}")
    public String deleteAdditionalInfo(@PathVariable Long additionalInfoId) {
        return additionalInfoService.deleteAdditionalInfo(additionalInfoId);
    }
}

