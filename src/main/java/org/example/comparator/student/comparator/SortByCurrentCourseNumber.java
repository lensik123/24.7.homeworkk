package org.example.comparator.student.comparator;

import org.example.model.Student;

public class SortByCurrentCourseNumber implements StudentComparator {

  @Override
  public int compare(Student o1, Student o2) {
    return Integer.compare(o1.getCurrentCourseNumber(), o2.getCurrentCourseNumber());
  }
}
