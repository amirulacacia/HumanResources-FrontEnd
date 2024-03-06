package campolina.hrgroup.hrapp.controller.information;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import campolina.hrgroup.hrapp.model.information.Reference;
import campolina.hrgroup.hrapp.service.information.ReferenceService;

@RestController
@RequestMapping("/reference")
public class ReferenceController {
    
    @Autowired
    private ReferenceService referenceService;

    @PostMapping("additional-info/{addsInfoId}")
    public Reference createReference(@RequestBody Reference reference, @PathVariable Long addsInfoId) {
        return referenceService.createReference(reference, addsInfoId);
    }

    @GetMapping("/{referenceId}")
    public Reference getReferenceById(@PathVariable Long referenceId){
        return referenceService.getReferenceById(referenceId);
    }

    @GetMapping
    public List<Reference> getAllReference(){
        return referenceService.getAllReference();
    }

    @PutMapping("/{referenceId}")
    public Reference updateReference(@RequestBody Reference reference, @PathVariable Long referenceId){
        return referenceService.updateReference(reference, referenceId);
    }

    @DeleteMapping("/{referenceId}")
    public String deleteReference(@PathVariable Long referenceId){
        return referenceService.deleteReference(referenceId);
    }
}
