package com.tp.api.service;

import com.tp.api.entities.FormClass;
import com.tp.api.entities.User;
import com.tp.api.forms.dao.FormClassDao;
import com.tp.api.repository.FormClassRepository;
import com.tp.api.repository.UserRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

  @Autowired
  private UserRepository userRepository;

  private User getUserByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  public List<FormClassDao> getFormClasses(String teacherUsername) {
    User teacher = getUserByUsername(teacherUsername);

    List<FormClass> formClasses = teacher.getFormClasses();
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

  public void addFormClass(FormClassDao formClassDao) {
    User teacher = getUserByUsername(formClassDao.getTeacherUsername());
    List<FormClass> formClasses = teacher.getFormClasses();
    FormClass formClass = formClassMapper.map(formClassDao, FormClass.class);
    formClasses.add(formClass);
    teacher.setFormClasses(formClasses);
    userRepository.save(teacher);
  }

}
