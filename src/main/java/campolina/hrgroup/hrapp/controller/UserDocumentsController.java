package campolina.hrgroup.hrapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import campolina.hrgroup.hrapp.model.UserDocuments;
import campolina.hrgroup.hrapp.service.UserDocumentsService;

@RestController
@RequestMapping("/userDocuments")
public class UserDocumentsController {

    @Autowired
    private UserDocumentsService userDocumentsService;

    @PostMapping
    public UserDocuments createUserDocuments(@RequestBody UserDocuments userDocuments) {
        return userDocumentsService.createUserDocuments(userDocuments);
    }

    @GetMapping("/{userDocumentsId}")
    public UserDocuments getUserDocumentsById(@PathVariable Long userDocumentsId) {
        return userDocumentsService.getUserDocumentsById(userDocumentsId);
    }

    @GetMapping
    public List<UserDocuments> getAllUserDocuments() {
        return userDocumentsService.getAllUserDocuments();
    }

    @PutMapping("/{userDocumentsId}")
    public UserDocuments updateUserDocuments(@RequestBody UserDocuments userDocuments,
                                             @PathVariable Long userDocumentsId) {
        return userDocumentsService.updateUserDocuments(userDocuments);
    }

    @DeleteMapping("/{userDocumentsId}")
    public String deleteUserDocuments(@PathVariable Long userDocumentsId) {
        return userDocumentsService.deleteUserDocuments(userDocumentsId);
    }
}

