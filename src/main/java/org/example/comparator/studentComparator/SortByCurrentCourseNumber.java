package org.example.comparator.studentComparator;

import org.example.classes.Student;

public class SortByCurrentCourseNumber implements StudentComparator {

  @Override
  public int compare(Student o1, Student o2) {
    return Integer.compare(o1.getCurrentCourseNumber(), o2.getCurrentCourseNumber());
  }
}
