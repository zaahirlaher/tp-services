package com.tp.api.controller;

import com.tp.api.forms.dao.FormClassDao;
import com.tp.api.service.FormClassService;
import java.util.List;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormClassController {

    @Autowired
    @Setter
    private FormClassService formClassService;

    @GetMapping("/getFormClass")
    @CrossOrigin
    public ResponseEntity<FormClassDao> getFormClass() {
        FormClassDao formClass = formClassService.getFormClass();
        if (formClass == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(formClass);
        }
    }

    @GetMapping("/getFormClasses")
    @CrossOrigin
    public ResponseEntity<List<FormClassDao>> getFormClasses() {
        List<FormClassDao> formClasses = formClassService.getFormClasses();
        if (formClasses.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(formClasses);
        }
    }

    @PostMapping("/addFormClass")
    @CrossOrigin
    public ResponseEntity addFormClass(@RequestBody FormClassDao formClassDao) {
        boolean success = formClassService.addFormClass(formClassDao);
        if (success) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
