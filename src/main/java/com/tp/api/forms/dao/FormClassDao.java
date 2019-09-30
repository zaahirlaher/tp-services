package com.tp.api.forms.dao;

import com.tp.api.entities.Learner;
import java.util.List;
import lombok.Data;

@Data
public class FormClassDao {

    private Integer id;
    private String grade;
    private int year;
    private List<Learner> learnerList;
    private boolean isCurrent;

}
