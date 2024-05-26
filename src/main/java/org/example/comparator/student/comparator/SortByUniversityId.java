package org.example.comparator.student.comparator;

import org.apache.commons.lang3.StringUtils;
import org.example.model.Student;

public class SortByUniversityId implements StudentComparator {

  @Override
  public int compare(Student o1, Student o2) {
    return StringUtils.compare(o1.getUniversityId(), o2.getUniversityId());
  }
}
