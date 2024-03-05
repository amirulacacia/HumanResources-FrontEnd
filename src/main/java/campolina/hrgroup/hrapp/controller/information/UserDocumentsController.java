package campolina.hrgroup.hrapp.controller.information;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import campolina.hrgroup.hrapp.model.information.UserDocuments;
import campolina.hrgroup.hrapp.service.information.UserDocumentsService;

@RestController
@RequestMapping("/userDocuments")
public class UserDocumentsController {

    @Autowired
    private UserDocumentsService userDocumentsService;

    @PostMapping("{user}/{userId}")
    public UserDocuments createUserDocuments(@RequestBody UserDocuments userDocuments,
            @PathVariable("user") String user, @PathVariable("userId") Long userId) {
        return userDocumentsService.createUserDocuments(userDocuments, user, userId);
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
        return userDocumentsService.updateUserDocuments(userDocuments, userDocumentsId);
    }

    @DeleteMapping("/{userDocumentsId}")
    public String deleteUserDocuments(@PathVariable Long userDocumentsId) {
        return userDocumentsService.deleteUserDocuments(userDocumentsId);
    }
}
