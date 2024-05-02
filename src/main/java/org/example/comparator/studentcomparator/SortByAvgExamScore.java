package org.example.comparator.studentcomparator;

import org.example.classes.Student;

public class SortByAvgExamScore implements StudentComparator {

  @Override
  public int compare(Student o1, Student o2) {
    return Float.compare(o2.getAvgExamScore(), o1.getAvgExamScore());
  }
}
