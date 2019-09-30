package com.tp.api.service;

import com.tp.api.entities.FormClass;
import com.tp.api.forms.dao.FormClassDao;
import com.tp.api.repository.FormClassRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.Setter;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FormClassService {

    @Autowired
    private MapperFacade formClassMapper;

    @Autowired
    @Setter
    private FormClassRepository formClassRepository;

    public FormClassDao getFormClass() {
        Optional<FormClass> formClassOption = formClassRepository.findById(1);
        if (formClassOption.isPresent()) {
            FormClass formClass = formClassOption.get();
            return formClassMapper.map(formClass, FormClassDao.class);
        } else {
            return null;
        }
    }

    public List<FormClassDao> getFormClasses() {
        List<FormClass> formClasses = formClassRepository.findAll();
        List<FormClassDao> formClassesDao = new ArrayList();
        if (formClasses.isEmpty()) {
            return null;
        } else {
            for (FormClass formClass : formClasses) {
                FormClassDao formClassDao = formClassMapper.map(formClass, FormClassDao.class);
                if (formClass.getYear() == LocalDate.now().getYear()) {
                    formClassDao.setCurrent(true);
                }
                formClassesDao.add(formClassDao);
            }
            return formClassesDao;
        }
    }

    public boolean addFormClass(FormClassDao formClassDao) {
        FormClass formClass = formClassMapper.map(formClassDao, FormClass.class);
        formClassRepository.save(formClass);
        return (formClass != null || formClass.getId() != null) ? true : false;
    }

}
