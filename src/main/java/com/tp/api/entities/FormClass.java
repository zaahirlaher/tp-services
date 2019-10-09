package com.tp.api.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "formclass")
@Data
@NoArgsConstructor
public class FormClass implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Long id;

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "grade")
  private String grade;

  @Basic(optional = false)
  @NotNull
  @Column(name = "year")
  private int year;

  @OneToMany(mappedBy = "formClassId", fetch = FetchType.LAZY)
  private List<Learner> learnerList;

  @ManyToMany(mappedBy = "formClasses", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
  private List<User> teachers = new ArrayList();
}
