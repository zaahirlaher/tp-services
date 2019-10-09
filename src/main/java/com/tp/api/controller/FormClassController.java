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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class FormClassController {

    @Autowired
    @Setter
    private FormClassService formClassService;

    @GetMapping("/getFormClasses")
    @CrossOrigin
    public ResponseEntity<List<FormClassDao>> getFormClasses(@RequestParam("teacherUserName") String teacherUserName) {
        List<FormClassDao> formClasses = formClassService.getFormClasses(teacherUserName);
        if (formClasses == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(formClasses);
        }
    }

    @PostMapping("/addFormClass")
    @CrossOrigin
    public ResponseEntity<List<FormClassDao>> addFormClass(@RequestBody FormClassDao formClassDao) {
        try {
            formClassService.addFormClass(formClassDao);

            List<FormClassDao> formClasses = formClassService.getFormClasses(formClassDao.getTeacherUsername());

            return ResponseEntity.ok(formClasses);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
