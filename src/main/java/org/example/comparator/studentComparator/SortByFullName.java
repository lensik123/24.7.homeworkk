package org.example.comparator.studentComparator;

import org.apache.commons.lang3.StringUtils;
import org.example.classes.Student;

public class SortByFullName implements StudentComparator {

  @Override
  public int compare(Student o1, Student o2) {
    return StringUtils.compare(o1.getFullName(), o2.getFullName());
  }
}
