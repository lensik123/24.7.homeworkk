package org.example.comparator.student.comparator;

import org.apache.commons.lang3.StringUtils;
import org.example.model.Student;

public class SortByFullName implements StudentComparator {

  @Override
  public int compare(Student o1, Student o2) {
    return StringUtils.compare(o1.getFullName(), o2.getFullName());
  }
}
